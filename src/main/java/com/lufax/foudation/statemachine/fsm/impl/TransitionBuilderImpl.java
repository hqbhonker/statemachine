/**
 * Description: TransitionBuilderImpl
 * Author: 
 * Update: (2015-06-19 15:47)
 */
package com.lufax.foudation.statemachine.fsm.impl;

import com.lufax.foudation.statemachine.fsm.*;
import com.lufax.foudation.statemachine.fsm.builder.*;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * Created by wuchenlv565 on 6/19/15.
 */
public class TransitionBuilderImpl implements TransitionBuilder, On, To, When, MultiTo {

  //key 状态的getCode
    private final Map<String, MutableState> states;

    public TransitionBuilderImpl(Map<String, MutableState> states) {
        this.states=states;
    }
    private MutableState sourceState;


    private MutableTransition transition;

    @Override
    public void to(State... targetStates) {
        for(State state:targetStates) {
            Assert.notNull(state);
            Assert.hasText(state.getCode());
        }
        for(State targetState:targetStates) {
            transition.setTargetState(newState(targetState));
        }
    }

    @Override
    public When on(Event event) {
        Assert.notNull(event);
        Assert.hasText(event.getCode());
        transition = sourceState.addTransitionOn(event);
        return this;
    }

    @Override
    public void to(State targetState) {
        Assert.notNull(targetState);
        Assert.hasText(targetState.getCode());
        transition.setTargetState(newState(targetState));

    }

    @Override
    public On from(State sourceSatate) {
        Assert.notNull(sourceSatate);
        Assert.hasText(sourceSatate.getCode());
       this.sourceState=newState(sourceSatate);
        return this;
    }

    @Override
    public On fromInit(State sourceSatate) {
        Assert.notNull(sourceSatate);
        Assert.hasText(sourceSatate.getCode());
        this.sourceState=newState(sourceSatate);
        sourceState.isInitState(true);
        return this;
    }

    @Override
    public To perform(Action... actions) {
        for(Action action:actions) {
            Assert.notNull(action);
            Assert.notNull(action.getActionClass());
            Assert.hasText(action.getActionMethod());
            transition.addAction(new ActionProxy(action));
        }

        return this ;
    }

    @Override
    public MultiTo performDecisionAction(Action decisionAction,Action... actions) {
        Assert.notNull(decisionAction);
        Assert.notNull(decisionAction.getActionClass());
        Assert.hasText(decisionAction.getActionMethod());
        transition.addActions(new ActionProxy(decisionAction,true));
         this.perform(actions);
        return this;
    }
    private MutableState newState(State state) {
        if(states.get(state.getCode())!=null){
            return states.get(state.getCode());
        }else {
            MutableState mutableState= new StateImpl(state);
            states.put(state.getCode(),mutableState);
            return mutableState;
        }
    }

}


