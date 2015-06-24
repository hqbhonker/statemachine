package com.lufax.foudation.statemachine.fsm;

import java.awt.*;

/**
 * Created by Administrator on 2015/6/24.
 */
public class ActionProxy  implements Action{

    private boolean isDeciscionAction;
    private Action action ;

    public ActionProxy(Action action) {
      this.action=action;
    }
    public ActionProxy(Action action, boolean isDeciscionAction) {
        this.action=action;
        this.isDeciscionAction=isDeciscionAction;
    }
    @Override
    public boolean isAsync() {
        return action.isAsync();
    }


    public boolean isDecisionAction() {
        return isDeciscionAction;
    }

    @Override
    public Class<?> getActionClass() {
        return action.getActionClass();
    }

    @Override
    public String getActionMethod() {
        return action.getActionMethod();
    }
    public Action getAction() {
        return action;
    }

    public boolean isDeciscionAction() {
        return isDeciscionAction;
    }


}
