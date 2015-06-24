package com.lufax.foudation.statemachine.fsm.builder;


import com.lufax.foudation.statemachine.fsm.Event;

/**
 * Created by wuchenlv565 on 6/17/15.
 */
public interface On {
    public When on(Event event);
}
