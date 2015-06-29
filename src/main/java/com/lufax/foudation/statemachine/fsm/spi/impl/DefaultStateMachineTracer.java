package com.lufax.foudation.statemachine.fsm.spi.impl;

import com.lufax.foudation.statemachine.fsm.StateMachineContext;
import com.lufax.foudation.statemachine.fsm.model.StateMachineSerialModel;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineModelKeeper;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineTracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2015/6/22.
 */
@Service(value="DefaultStateMachineTracer")
public class DefaultStateMachineTracer  implements StateMachineTracer{
    @Autowired
    @Qualifier("DefaultStateMachineModelKeeper")
    private StateMachineModelKeeper stateMachineModelKeeper;

    @Override
    public Object enterProcess(StateMachineContext context) {
        StateMachineSerialModel model=new StateMachineSerialModel();
        model.setId( UUID.randomUUID().toString());
        model.setSourceState(context.getStateMachineModel().getCurrentState());
        model.setStateMachineModelId(context.getStateMachineModel().getId());
        model.setCreatedBy("admin");
        model.setCreatedDate(new Date());
        model.setModifiedBy("admin");
        stateMachineModelKeeper.saveOrUpdateStateMachineSerialModel(model);
        return model;
    }

    @Override
    public void exitProcess(StateMachineContext context, Object token, Exception error) {
        StateMachineSerialModel model=(StateMachineSerialModel)token;
        model.setDescState(context.getStateMachineModel().getCurrentState());
        stateMachineModelKeeper.saveOrUpdateStateMachineSerialModel(model);

    }
}
