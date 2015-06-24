package com.lufax.foudation.statemachine.fsm.impl;

import com.lufax.foudation.statemachine.fsm.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/21.
 */
public class TransitionImpl implements MutableTransition {

    private ImmutableState  sourceState;

    private List<ImmutableState>  targetStateList=new ArrayList<ImmutableState>();

    private Event event;

    private List<ActionProxy> actions=new ArrayList<ActionProxy>();
    @Override
    public void setSourceState(ImmutableState sourceState) {
        this.sourceState=sourceState;
    }

    @Override
    public void setTargetState(ImmutableState... targetStates) {
        for(ImmutableState targetState:targetStates) {
            targetStateList.add(targetState);
        }
    }

    @Override
    public void addAction(ActionProxy action) {
        actions.add(action);
    }

    @Override
    public void addActions(ActionProxy... actions) {
      for(ActionProxy action:actions)  {
         this. actions.add(action);
        }
    }

    @Override
    public void setEvent(Event event) {
     this.event=event;
    }

    @Override
    public Event getEvent() {
        return event;
    }

    @Override
    public List<ImmutableState> getTargetStates() {
        return targetStateList;
    }

    @Override
    public List<ActionProxy> getActions() {
        return actions;
    }
}
