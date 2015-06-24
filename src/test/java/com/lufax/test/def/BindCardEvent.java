package com.lufax.test.def;

import com.lufax.foudation.statemachine.fsm.Event;

/**
 * Created by Administrator on 2015/6/22.
 */
public enum BindCardEvent implements Event {


    AUTHSEND("AUTH_SEND",false),
    RE_AUTHSEND("RE_AUTHSEND",true),
    CONFIRM("CONFIRM",false);


    private String code;
    private boolean isAutoTrigger;
    BindCardEvent(String code,boolean isAutoTrigger) {
        this.code=code;
        this.isAutoTrigger=isAutoTrigger;
    }
    @Override
    public String getCode() {
        return code;
    }
    public boolean isAutoTrigger(){
        return isAutoTrigger;
    }
}
