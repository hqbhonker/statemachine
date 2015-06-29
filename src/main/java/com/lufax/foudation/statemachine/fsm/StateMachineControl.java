package com.lufax.foudation.statemachine.fsm;

import com.lufax.foudation.statemachine.fsm.component.impl.StateMachineConfiguration;
import com.lufax.foudation.statemachine.fsm.exception.ErrorCodes;
import com.lufax.foudation.statemachine.fsm.exception.StateMachineException;
import com.lufax.foudation.statemachine.fsm.impl.StateMachineContextImpl;
import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineActionRepository;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineModelKeeper;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineTracer;
import com.lufax.foudation.statemachine.fsm.util.ReflectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2015/6/22.
 */
@Service(value = "StateMachineControl")
public class StateMachineControl {
    @Autowired
    @Qualifier("DefaultStateMachineTracer")
    private StateMachineTracer stateMachineTracer;
    @Autowired
    @Qualifier("DefaultStateMachineModelKeeper")
    private StateMachineModelKeeper stateMachineModelKeeper;
    @Autowired
    @Qualifier("DefaultSatetMachineActionRepository")
    private StateMachineActionRepository stateMachineActionRepository;


    public void handle(StateMachineContext context, State initState, String bizType, String bizRefNo) {
        StateMachineModel model = this.getStateMachineModel(initState, bizType, bizRefNo);
        context.setStateMachineModel(model);
        final Object processToken = stateMachineTracer.enterProcess(context);
        Exception processError = null;
        try {
            runProcess(context, processToken);
        } catch (RuntimeException e) {
            processError = e;
            throw e;
        } finally {
            stateMachineTracer.exitProcess(context, processToken, processError);
        }
        ImmutableState descState=context.getStateMachine().getState(context.getCurrentState());
        if(descState.getAllTransitions().size()==1 && descState.getAllTransitions().get(0).getEvent().isAutoTrigger()) {
            context.setEventCode(descState.getAllTransitions().get(0).getEvent().getCode());
            handle(context, null,  bizType, bizRefNo);
        }


    }

    private void runProcess(final StateMachineContext context,
                            Object processToken) {

        StateMachineModel model = context.getStateMachineModel();
        final Map<ActionProxy, Future<?>> futures = new HashMap<ActionProxy, Future<?>>();
        if (!stateMachineModelKeeper.active(model)) {
            throw new StateMachineException(ErrorCodes.STATEMACHINE_MODEL_OUTDATED, new Object[]{model.getBizType(), model.getBizRefNo()});
        }
        List<ActionProxy> actionClasses = getExecuteAction(context);
        String descState = null;
        for (ActionProxy action : actionClasses) {
            final Object object = stateMachineActionRepository.getAction(action.getActionClass());
            final Method method = ReflectUtils.getMethod(action.getActionClass(), action.getActionMethod(),new Class[]{Context.class});
            if (action.isAsync()) {
                Future<?> future = null;
                if (action.isDecisionAction()) {
                    future = StateMachineConfiguration.getExecutor().submit(new Callable<String>() {
                                                                                public String call() {
                                                                                    return (String) ReflectUtils.invoke(method, object,new Object[]{ context});
                                                                                }
                                                                            }
                    );
                } else {
                    future = StateMachineConfiguration.getExecutor().submit(new Runnable() {
                                                                                public void run() {
                                                                                    ReflectUtils.invoke(method, object, new Object[]{context});
                                                                                }
                                                                            }
                    );
                }
                futures.put(action, future);
            } else {
                if (action.isDecisionAction()) {
                    descState = (String) ReflectUtils.invoke(method, object,new Object[]{ context});
                } else {
                    ReflectUtils.invoke(method, object, new Object[]{context});
                }
            }
            for (Map.Entry<ActionProxy, Future<?>> entry : futures.entrySet()) {
                try {
                    if (entry.getKey().isDecisionAction()) {
                        descState = (String) entry.getValue().get();
                    } else {
                        entry.getValue().get();
                    }
                } catch (Exception e) {
                    entry.getValue().cancel(true);
                    //print log
                    throw new StateMachineException(e.getCause(), ErrorCodes.FSM_TRANSITION_ERROR, new Object[]{context.getCurrentState(), context.getEventCode(), action.getActionClass() + ":" + action.getActionMethod()});
                }
            }
            this.updateStateMachineModelStatus(context, descState);
            model=   stateMachineModelKeeper.saveOrUpdateStateMachineModel(model);



        }
    }
    private void updateStateMachineModelStatus(StateMachineContext context, String descState) {
        StateMachine stateMachine = context.getStateMachine();
        ImmutableState immutableDescState=null;
        List<ImmutableState> descStates = stateMachine.getState(context.getCurrentState()).getTransition(context.getEventCode()).getTargetStates();
        if (StringUtils.isNotEmpty(descState)) {
            for (ImmutableState immutableState : descStates) {
                if (StringUtils.equals(immutableState.getState().getCode(), descState)) {
                    immutableDescState=immutableState;
                }
            }
            if (immutableDescState==null) {
                throw new StateMachineException(ErrorCodes.ILLEGAL_DESC_STATE, descState);
            }
        } else {
            immutableDescState= descStates.get(0);
            descState = immutableDescState.getState().getCode();
        }
        if(immutableDescState.isFinalState()){
            context.getStateMachineModel().setDone(true);
        }
        context.getStateMachineModel().setCurrentState(descState);
    }

    private StateMachineModel getStateMachineModel(State initState, String bizType, String bizRefNo) {
        StateMachineModel model = stateMachineModelKeeper.getStateMachineModelBy(bizType, bizRefNo);
        if (StringUtils.isEmpty(model.getCurrentState())) {
            model.setCurrentState(initState.getCode());
        }
        return model;
    }


    private List<ActionProxy> getExecuteAction(StateMachineContext context) {
        ImmutableTransition transition = this.getTransition(context);
        return transition.getActions();
    }

    private ImmutableTransition getTransition(StateMachineContext context) {
        StateMachine stateMachine = context.getStateMachine();
        ImmutableState immutableState = stateMachine.getState(context.getStateMachineModel().getCurrentState());
        ImmutableTransition transition = immutableState.getTransition(context.getEventCode());
        return transition;
    }

}
