package com.lufax.foudation.statemachine.fsm.impl;

import com.lufax.foudation.statemachine.fsm.*;
import org.springframework.util.Assert;

import java.util.*;

/**
 * Created by Administrator on 2015/6/21.
 */
public class StateImpl implements MutableState {

    private State state;

    private boolean isInitState;

    private Map<String, ImmutableTransition> transitions = new HashMap<String, ImmutableTransition>();

    StateImpl(State state) {
        this.state = state;
    }

    @Override
    public MutableTransition addTransitionOn(Event event) {
        Assert.hasText(event.getCode());
        MutableTransition newTransition = new TransitionImpl();
        newTransition.setSourceState(this);
        newTransition.setEvent(event);
        transitions.put(event.getCode(), newTransition);
        return newTransition;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public List<ImmutableTransition> getAllTransitions() {
        return new ArrayList<ImmutableTransition>(transitions.values());
    }

    @Override
    public ImmutableTransition getTransition(String  e) {
        return transitions.get(e);
    }

    @Override
    public boolean isFinalState() {
        if (transitions.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isInitState() {
        return isInitState;
    }
    public void isInitState(boolean isInitState){
        this.isInitState=isInitState;
    }
}
