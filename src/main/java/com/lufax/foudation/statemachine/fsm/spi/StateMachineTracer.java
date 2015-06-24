package com.lufax.foudation.statemachine.fsm.spi;

import com.lufax.foudation.statemachine.fsm.StateMachineContext;

/**
 * Created by Administrator on 2015/6/22.
 */
public interface StateMachineTracer {

    /**
     * 进入Process。可以返回一个token，该token会在调用exitProcess时被传入。
     *
     * @param context
     @return token
     */
    public Object enterProcess(StateMachineContext context);

    /**
     * 退出Process。
     *
     * @param context
     * @param token
     * @param error - 执行Process时发生的错误。
     */
    public void exitProcess(StateMachineContext context, Object token, Exception error);

}
