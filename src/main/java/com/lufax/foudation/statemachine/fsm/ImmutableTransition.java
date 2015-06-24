package com.lufax.foudation.statemachine.fsm;


import java.util.List;

/**
 * Created by wuchenlv565 on 6/19/15.
 */
public interface ImmutableTransition {

    public Event getEvent();

    public List<ImmutableState> getTargetStates();

    public List<ActionProxy> getActions();


}
