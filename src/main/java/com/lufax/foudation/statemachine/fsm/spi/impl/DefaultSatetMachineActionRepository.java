package com.lufax.foudation.statemachine.fsm.spi.impl;

import com.lufax.foudation.statemachine.fsm.Action;
import com.lufax.foudation.statemachine.fsm.exception.ErrorCodes;
import com.lufax.foudation.statemachine.fsm.exception.StateMachineException;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineActionRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/6/22.
 */
@Service(value="DefaultSatetMachineActionRepository")
public class DefaultSatetMachineActionRepository implements StateMachineActionRepository  ,ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public <T> T getAction(Class<T> clazz) {
        T object= (T) applicationContext.getBean(clazz);
        if(object==null) {
            throw  new StateMachineException(ErrorCodes.CLASS_NOT_FOUND,clazz.getName());
        }
        return object;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
