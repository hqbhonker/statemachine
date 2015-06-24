package com.lufax.foudation.statemachine.fsm.spi;

import com.lufax.foudation.statemachine.fsm.Action;

/**
 * Created by Administrator on 2015/6/22.
 */
public interface StateMachineActionRepository {
    public <T> T getAction(Class<T> clazz);
}
