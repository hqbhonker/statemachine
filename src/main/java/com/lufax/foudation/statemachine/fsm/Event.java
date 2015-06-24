package com.lufax.foudation.statemachine.fsm;

/**
 * Created by wuchenlv565 on 6/19/15.
 */
public interface Event {
    public String getCode();

    public boolean isAutoTrigger();
}
