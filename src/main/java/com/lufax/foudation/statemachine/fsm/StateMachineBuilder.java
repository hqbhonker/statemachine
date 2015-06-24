package com.lufax.foudation.statemachine.fsm;

import com.lufax.foudation.statemachine.fsm.builder.TransitionBuilder;

/**
 * Created by Administrator on 2015/6/21.
 */
public interface StateMachineBuilder {

    public  TransitionBuilder transition();

     public String getBizType();

     public void check();


}
