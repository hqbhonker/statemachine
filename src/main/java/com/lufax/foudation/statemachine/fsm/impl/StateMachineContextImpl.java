package com.lufax.foudation.statemachine.fsm.impl;

import com.lufax.foudation.statemachine.fsm.StateMachine;
import com.lufax.foudation.statemachine.fsm.StateMachineContext;
import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2015/6/22.
 */
public class StateMachineContextImpl  implements StateMachineContext{
    private StateMachineModel stateMachineModel;
    private String eventCode;
    private Object result;
    private Map<String,Object> data=new ConcurrentHashMap<String, Object>();
    private StateMachine stateMachine;

    public  StateMachineContextImpl(StateMachine stateMachine){
        this.stateMachine=stateMachine;
    }

    @Override
    public String getEventCode() {
        return eventCode;
    }

    @Override
    public Object setResult() {
        return result;
    }

    @Override
    public Object getResult() {
        return result;
    }

    @Override
    public void put(String key, Object value) {
        data.put(key,value);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        return (T) data.get(key);
    }

    @Override
    public StateMachineModel getStateMachineModel() {
        return stateMachineModel;
    }

    @Override
    public String getBizRef() {
        return stateMachineModel.getBizRefNo();
    }

    @Override
    public String getCurrentState() {
        return stateMachineModel.getCurrentState();
    }
    @Override
    public void  setEventCode(String eventCode){
        this.eventCode=eventCode;
    }
    @Override
     public void setStateMachineModel(StateMachineModel model){
         this.stateMachineModel=model;
     }
    @Override
    public StateMachine getStateMachine(){
       return stateMachine;
    }
}
