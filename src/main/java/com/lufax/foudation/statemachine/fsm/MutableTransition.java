package com.lufax.foudation.statemachine.fsm;


import java.util.List;

/**
 * Created by wuchenlv565 on 6/19/15.
 */
public interface MutableTransition extends ImmutableTransition {

    public void setSourceState(ImmutableState sourceState);

    public void setTargetState(ImmutableState... targetStates);

    public void addAction(ActionProxy action);

    public void addActions(ActionProxy...  actions );

    public void setEvent(Event event);

}
