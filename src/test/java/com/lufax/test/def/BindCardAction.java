package com.lufax.test.def;

import com.lufax.foudation.statemachine.fsm.Action;
import com.lufax.test.BindCardService;

/**
 * Created by Administrator on 2015/6/24.
 */
public enum BindCardAction  implements Action{
    AUTHSEND_ACTION(BindCardService.class,"authSend"),
    RE_AUTHSEND_ACTION(BindCardService.class,"reAuthSend"),
    CONFIRM_ACTION(BindCardService.class,"confirm");
    private Class<?> actionClass;
    private boolean isAsync=false;

    private String actionMethod;
    BindCardAction(Class<?> actionClass,String actionMethod) {
        this.actionClass=actionClass;
        this.actionMethod=actionMethod;
    }



    @Override
    public boolean isAsync() {
        return isAsync;
    }



    @Override
    public Class<?> getActionClass() {
        return actionClass;
    }

    @Override
    public String getActionMethod() {
        return actionMethod;
    }
}
