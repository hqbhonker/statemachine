package com.lufax.foudation.statemachine.fsm.impl;

import com.lufax.foudation.statemachine.fsm.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/22.
 */

public class StateMachineImpl implements StateMachine {
    private   StateMachineControl stateMachineControl;
    private Map<String, ? extends ImmutableState> states;
    private String bizType;

    public StateMachineImpl(Map<String, ? extends ImmutableState> states,String bizType) {

        this.bizType=bizType;
        this.states=states;
   }

    @Override
    public void fire(Event event, String bizRef, Map<String, Object> datas) {
        StateMachineContext context=new StateMachineContextImpl(this);
        for( Map.Entry<String , Object>  entrySet:datas.entrySet()) {
            context.put(entrySet.getKey(),entrySet.getValue());
        }
        context.setEventCode(event.getCode());
        stateMachineControl.handle(context,this.getInitState().getState(),bizType,bizRef);

    }

    public void fire(Event event,String bizRef){
        this.fire(event,bizRef,new HashMap<String,Object>());
    }


    public ImmutableState getState(String sourceState) {
        return states.get(sourceState);
    }

    public void setStateMachineControl(StateMachineControl stateMachineControl) {
        this.stateMachineControl = stateMachineControl;
    }
    public ImmutableState getInitState() {
        for(ImmutableState state:states.values()){
            if(state.isInitState()) {
                return state;
            }
        }
        return null;
    }

}
