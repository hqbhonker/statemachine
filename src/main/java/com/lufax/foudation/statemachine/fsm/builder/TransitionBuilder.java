package com.lufax.foudation.statemachine.fsm.builder;

import com.lufax.foudation.statemachine.fsm.State;

/**
 * Created by wuchenlv565 on 6/19/15.
 */
public interface TransitionBuilder {

    public On from(State sourceSatate) ;

    public On fromInit(State sourceSatate) ;
}
