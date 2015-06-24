package com.lufax.foudation.statemachine.fsm;

import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;

/**
 * Created by Administrator on 2015/6/22.
 */
public interface StateMachineContext extends Context {

    public String getEventCode();

    public StateMachineModel getStateMachineModel();



    public void setEventCode(String eventCode);


    public void setStateMachineModel(StateMachineModel model);


    public StateMachine getStateMachine();
}
