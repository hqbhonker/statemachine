package com.lufax.foudation.statemachine.fsm.spi.impl;

import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import com.lufax.foudation.statemachine.fsm.model.StateMachineSerialModel;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineModelKeeper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/22.
 */
@Service(value="DefaultStateMachineModelKeeper")
public class DefaultStateMachineModelKeeper implements StateMachineModelKeeper {

    private static Map<String,StateMachineModel> cache=new HashMap<String,StateMachineModel>();

    private static Map<String,StateMachineSerialModel> serialCache=new HashMap<String,StateMachineSerialModel>();
    @Override
    public StateMachineModel getStateMachineModelBy(String bizType, String bizRefNo) {
       if(cache.get(bizType+":"+bizRefNo)==null) {
           StateMachineModel stateMacineModel=new StateMachineModel(bizType,bizRefNo);
           return stateMacineModel;

       }
        return cache.get(bizType+":"+bizRefNo);
    }

    @Override
    public void saveOrUpdateStateMachineModel(StateMachineModel model) {
        cache.put(model.getBizType()+":"+model.getBizRefNo(),model);

    }

    @Override
    public void saveOrUpdateStateMachineSerialModel(StateMachineSerialModel model) {
        serialCache.put(model.getId(),model);
    }

    @Override
    public boolean active(StateMachineModel model) {
        return true;
    }
}

