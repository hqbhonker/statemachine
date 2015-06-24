package com.lufax.test.def;

import com.lufax.foudation.statemachine.fsm.State;

/**
 * Created by Administrator on 2015/6/22.
 *
 *              |-----authSendEvent------- INIT--authSendEnevnt--------|
                |                                                      |
                |                                                      |
 *             \|/                                                   \|/
 *            AUTHSEND  -from-------------confirmEvent--------to ------------FAIL
 *                      ---to--------------RE_AUTHSEND--------------from------FAIL
 *               |
 *               | confirmEvent
 *               |
 *              \|/
 *            SUCCESS
 *
 *
 *
 */
public enum  BindCardState implements State {
    INIT("INIT"),
    AUTHSEND("AUTH_SEND"),
    FAIL("FAIL"),

    SUCCESS("SUCCESS");
    BindCardState(String code) {
        this.code=code;
    }
    private String code;

    @Override
    public String getCode() {
        return code;
    }
}
