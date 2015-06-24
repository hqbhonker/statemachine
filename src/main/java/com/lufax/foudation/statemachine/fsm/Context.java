package com.lufax.foudation.statemachine.fsm;

import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;

/**
 * Created by Administrator on 2015/6/22.
 */
public interface Context {
    public void put(String key, Object value);

    public <T> T get(String key, Class<T> clazz);

    public Object setResult();

    public Object getResult();

    public String getBizRef();

    public String getCurrentState();


}
