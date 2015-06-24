package com.lufax.test;

import com.lufax.foudation.statemachine.fsm.Context;
import com.lufax.test.def.BindCardState;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/6/22.
 */
@Service
public class BindCardService {

    public String  authSend(Context context) {
        System.out.println("AuthSendAction");

        return BindCardState.AUTHSEND.getCode();
    }

    public String confirm(Context context) {
        System.out.println("confirm");
        context.put("reAuthSend","true");

        return BindCardState.FAIL.getCode();
    }

    public void  reAuthSend(Context context) {
        System.out.println("reAuthSend");
        System.out.println("reAuthSend status：" +context.get("reAuthSend",String.class));

    }


}
