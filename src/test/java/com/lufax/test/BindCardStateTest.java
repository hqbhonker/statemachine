package com.lufax.test;

import com.lufax.foudation.statemachine.fsm.StateMachine;
import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import com.lufax.foudation.statemachine.fsm.spi.StateMachineModelKeeper;
import com.lufax.test.def.BindCardEvent;
import com.lufax.test.def.BindCardState;
import junit.framework.Assert;
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
        String key=System.currentTimeMillis()/3600+" ";
        bindCardStateMachine.fire(BindCardEvent.AUTHSEND,key);
        StateMachineModel model= stateMachineModelKeeper.getStateMachineModelBy("Bind_Card_Process", key);
       Assert.assertEquals(model.getCurrentState(),BindCardState.AUTHSEND.getCode());
        bindCardStateMachine.fire(BindCardEvent.CONFIRM,key);
         model= stateMachineModelKeeper.getStateMachineModelBy("Bind_Card_Process",key);
        Assert.assertEquals(model.getCurrentState(), BindCardState.AUTHSEND.getCode());

    }
}
