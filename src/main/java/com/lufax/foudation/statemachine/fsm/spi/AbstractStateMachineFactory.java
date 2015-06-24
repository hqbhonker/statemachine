package com.lufax.foudation.statemachine.fsm.spi;

import com.lufax.foudation.statemachine.fsm.*;
import com.lufax.foudation.statemachine.fsm.impl.StateMachineImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2015/6/22.
 */

public abstract class AbstractStateMachineFactory implements InitializingBean {

   private  StateMachineBuilder stateMachineBuilder=null;
    @Autowired
    @Qualifier("StateMachineControl")
    private StateMachineControl stateMachineControl;
    //引擎定義
    public abstract void definition(StateMachineBuilder stateMachineBuilder);

   public  abstract String getBizType();

    public void   check(StateMachineBuilder stateMachineBuilder) {
        stateMachineBuilder.check();
    }

    public StateMachine createStateMachine() {
        StateMachine stateMachine= ((StateMachineCreator)stateMachineBuilder).createStateMachine();
        stateMachine.setStateMachineControl(stateMachineControl);
        return stateMachine;
    }

    public void afterPropertiesSet() {
        stateMachineBuilder = StateMachineBuilderFactory.getStateMachineBuilder(this.getBizType());
        definition(stateMachineBuilder);
        check(stateMachineBuilder);
    }

}
