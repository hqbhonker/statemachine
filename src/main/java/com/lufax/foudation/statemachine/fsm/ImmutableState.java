package com.lufax.foudation.statemachine.fsm;

import java.util.List;

/**
 * Created by wuchenlv565 on 6/19/15.
 */
public interface ImmutableState {

    public State getState();

    public List<ImmutableTransition> getAllTransitions();

    public ImmutableTransition getTransition(String  e);

    public boolean isFinalState();

    public boolean isInitState();


}
