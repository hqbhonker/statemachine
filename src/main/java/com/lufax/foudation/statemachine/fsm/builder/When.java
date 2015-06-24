package com.lufax.foudation.statemachine.fsm.builder;

import com.lufax.foudation.statemachine.fsm.Action;

/**
 * Created by wuchenlv565 on 6/17/15.
 */
public interface When {

    To perform(Action... action);


    MultiTo performDecisionAction(Action decisionAction,Action... actions);

}

