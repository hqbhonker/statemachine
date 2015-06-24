package com.lufax.foudation.statemachine.fsm;

/**
 * Created by wuchenlv565 on 6/19/15.
 */
public interface MutableState extends ImmutableState {
    MutableTransition addTransitionOn(Event event);

    public void isInitState(boolean isInitState);

}

