package com.lufax.foudation.statemachine.fsm.spi.impl;

import com.lufax.foudation.statemachine.fsm.dao.StateMachineDao;
import com.lufax.foudation.statemachine.fsm.dao.StateMachineSerialDao;
import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import com.lufax.foudation.statemachine.fsm.model.StateMachineSerialModel;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineModelKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2015/6/22.
 */
@Service(value="DefaultStateMachineModelKeeper")
public class DefaultStateMachineModelKeeper implements StateMachineModelKeeper {
   @Autowired
    private  StateMachineDao stateMachineDao;
   @Autowired
    private StateMachineSerialDao stateMachineSerialDao;
    @Override
    public StateMachineModel getStateMachineModelBy(String bizType, String bizRefNo) {
        StateMachineModel model=  stateMachineDao.findStateMachineByBizTpeAndBizRefNo(bizType, bizRefNo);
        if(model==null){
            model=new StateMachineModel(bizType,bizRefNo);
            model.setId(UUID.randomUUID().toString());
        }
        return model;
    }

    @Override
    public StateMachineModel saveOrUpdateStateMachineModel(StateMachineModel model) {
        StateMachineModel stateMachineModel=stateMachineDao.load(model.getId());
        if(stateMachineModel==null) {
            stateMachineDao.save(model);
        }else {
            stateMachineDao.update(model);
        }
        return stateMachineDao.load(model.getId());
    }

    @Override
    public void saveOrUpdateStateMachineSerialModel(StateMachineSerialModel model) {
        StateMachineSerialModel smModel=stateMachineSerialDao.load(model.getId());
        if(smModel==null) {
            stateMachineSerialDao.save(model);
        }else {
            stateMachineSerialDao.update(model.getId(), model.getDescState());
        }
    }

    @Override
    public boolean active(StateMachineModel model) {
        return true;
    }
}

