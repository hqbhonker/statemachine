package com.lufax.test;

import com.lufax.foudation.statemachine.fsm.StateMachine;
import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineModelKeeper;
import com.lufax.test.def.BindCardEvent;
import com.lufax.test.def.BindCardState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2015/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class BindCardStateTest {
    @Autowired
    @Qualifier("BindCardStateMachine")
    private StateMachine bindCardStateMachine;


    @Autowired
    @Qualifier("DefaultStateMachineModelKeeper")
    private StateMachineModelKeeper stateMachineModelKeeper;
    @Test
    public void testBindCardStateMachine(){
        bindCardStateMachine.fire(BindCardEvent.AUTHSEND, "test");



        StateMachineModel model= stateMachineModelKeeper.getStateMachineModelBy("Bind_Card_Process", "test");
        System.out.println(" current state:  "+model.getCurrentState());

        bindCardStateMachine.fire(BindCardEvent.CONFIRM,"test");

         model= stateMachineModelKeeper.getStateMachineModelBy("Bind_Card_Process", "test");
         System.out.println(" current state:  "+model.getCurrentState());

    }
}
