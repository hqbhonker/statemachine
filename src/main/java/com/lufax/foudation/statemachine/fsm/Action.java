package com.lufax.foudation.statemachine.fsm;

/**
 * Created by Administrator on 2015/6/21.
 */
public interface Action {


    public  boolean isAsync();


    public Class<?> getActionClass();

    public String getActionMethod();


}
