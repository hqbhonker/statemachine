package com.lufax.foudation.statemachine.fsm.builder;

import com.lufax.foudation.statemachine.fsm.State;

/**
 * Created by wuchenlv565 on 6/17/15.
 */
public interface MultiTo {

    public void to(State... targetStates);
}
