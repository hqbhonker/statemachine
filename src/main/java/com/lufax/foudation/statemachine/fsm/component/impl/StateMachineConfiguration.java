package com.lufax.foudation.statemachine.fsm.component.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2015/6/23.
 */
public class StateMachineConfiguration {

   private static  ExecutorService  executorService= Executors.newFixedThreadPool(10);

    public static ExecutorService getExecutor() {
        return executorService;
    }
}
