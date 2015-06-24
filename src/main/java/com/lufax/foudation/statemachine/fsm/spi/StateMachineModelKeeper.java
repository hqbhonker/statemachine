package com.lufax.foudation.statemachine.fsm.spi;

import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import com.lufax.foudation.statemachine.fsm.model.StateMachineSerialModel;

/**
 * Created by Administrator on 2015/6/22.
 */
public interface StateMachineModelKeeper {

    public StateMachineModel getStateMachineModelBy(String bizType,String bizRefNo);

    public void  saveOrUpdateStateMachineModel(StateMachineModel model);

    public void saveOrUpdateStateMachineSerialModel(StateMachineSerialModel model);

    public boolean active(StateMachineModel model) ;

}
