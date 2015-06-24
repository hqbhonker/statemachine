package com.lufax.foudation.statemachine.fsm;

import com.lufax.foudation.statemachine.fsm.impl.StateMachineBuilderImpl;

/**
 * Created by Administrator on 2015/6/22.
 */
public class StateMachineBuilderFactory {

    public static StateMachineBuilder getStateMachineBuilder(String bizType){
        return  new StateMachineBuilderImpl(bizType);
    }
}
