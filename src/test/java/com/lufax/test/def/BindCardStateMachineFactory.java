package com.lufax.test.def;

import com.lufax.foudation.statemachine.fsm.StateMachineBuilder;
import com.lufax.foudation.statemachine.fsm.spi.AbstractStateMachineFactory;
import com.lufax.test.BindCardService;
import com.lufax.test.def.BindCardEvent;
import com.lufax.test.def.BindCardState;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/6/22.
 */
@Service(value="BindCardStateMachineFactory")
public class BindCardStateMachineFactory  extends AbstractStateMachineFactory {
    @Override
    public void definition(StateMachineBuilder stateMachineBuilder) {


           stateMachineBuilder.transition().fromInit(BindCardState.INIT).on(BindCardEvent.AUTHSEND).
                performDecisionAction(BindCardAction.AUTHSEND_ACTION).to(BindCardState.AUTHSEND,BindCardState.FAIL);
          stateMachineBuilder.transition().from(BindCardState.AUTHSEND).on(BindCardEvent.CONFIRM).
                performDecisionAction(BindCardAction.CONFIRM_ACTION).to(BindCardState.SUCCESS,BindCardState.FAIL);
           stateMachineBuilder.transition().from(BindCardState.FAIL).on(BindCardEvent.RE_AUTHSEND).perform
                (BindCardAction.RE_AUTHSEND_ACTION).to(BindCardState.AUTHSEND);
    }

    @Override
    public String getBizType() {
        return "Bind_Card_Process";
    }
}

