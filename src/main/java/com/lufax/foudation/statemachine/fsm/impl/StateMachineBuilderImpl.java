package com.lufax.foudation.statemachine.fsm.impl;

import com.google.common.collect.Sets;
import com.lufax.foudation.statemachine.fsm.*;
import com.lufax.foudation.statemachine.fsm.builder.TransitionBuilder;
import com.lufax.foudation.statemachine.fsm.exception.ErrorCodes;
import com.lufax.foudation.statemachine.fsm.exception.StateMachineException;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2015/6/21.
 */
public class StateMachineBuilderImpl implements StateMachineBuilder, StateMachineCreator {

    private String bizType;

    private Map<String, MutableState> states = new ConcurrentHashMap<String, MutableState>();

    public StateMachineBuilderImpl(String bizType) {
        Assert.hasText(bizType);
        this.bizType = bizType;
    }
    @Override
    public TransitionBuilder transition()
    {
        return new TransitionBuilderImpl(states);
    }

    @Override
    public StateMachine createStateMachine() {
        return new StateMachineImpl(states, bizType);
    }


    public String getBizType() {
        return bizType;
    }

    public void check(){
        Assert.notEmpty(states);
        boolean hasFinalState=false;
        int initCount=0;
        for(Map.Entry<String, MutableState> state:states.entrySet())
        {   MutableState value=state.getValue();
            Set<String> eventCodeSet= Sets.newHashSet();
            if(value.isFinalState()) hasFinalState=true;
            if(value.isInitState())   {

                initCount++;
            }
            List<ImmutableTransition> transitions=value.getAllTransitions();
            for(ImmutableTransition transition:transitions) {
                if(eventCodeSet.contains(transition.getEvent().getCode())) {
                    throw new StateMachineException(ErrorCodes.ILLEGAL_TRANSIITION_DEF,new Object[]{state.getKey(),transition.getEvent().getCode()});
                }
                eventCodeSet.add(transition.getEvent().getCode());
            }
        }

        if(!hasFinalState) {
            throw new StateMachineException(ErrorCodes.NO_FINAL_STATE_DEF,new Object[]{bizType});
        }
        if(initCount!=1){
            throw new StateMachineException(ErrorCodes.NO_INIT_STATE_DEF,new Object[]{bizType});
        }
    }

}
