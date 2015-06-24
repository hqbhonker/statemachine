package com.lufax.foudation.statemachine.fsm;

import java.util.Map;

/**
 * Created by Administrator on 2015/6/21.
 */
public interface StateMachine {

    public void fire(Event  event,String bizRef);

    public void fire(Event event,String bizRef,Map<String,Object> data);

    public ImmutableState getState(String sourceState);

    public void setStateMachineControl(StateMachineControl stateMachineControl);

}
