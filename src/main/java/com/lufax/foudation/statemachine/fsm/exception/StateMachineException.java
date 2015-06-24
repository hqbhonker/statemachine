package com.lufax.foudation.statemachine.fsm.exception;

/**
 * Created by Administrator on 2015/6/22.
 */
public class StateMachineException  extends RuntimeException {


    private static final long serialVersionUID = -4324278329515258777L;
    private int errorCodeId;

    private Throwable targetException;

    private String errorMessage;

//    private String localizedErrorMessage;

    public StateMachineException(ErrorCodes errorCode) {
        this.errorCodeId = errorCode.getCode();
        this.errorMessage = String.format("%08d : %s.", getErrorCodeId(), errorCode.getDescription());
    }

    public StateMachineException(Throwable targetException, ErrorCodes errorCode) {
        this(errorCode);
        this.targetException = targetException;
    }

    public StateMachineException(ErrorCodes errorCode, Object...parameters) {
        this.errorCodeId = errorCode.getCode();
        this.errorMessage = String.format("%08d : %s.", getErrorCodeId(),
                String.format(errorCode.getDescription(), parameters));
    }

    public StateMachineException(Throwable targetException, ErrorCodes errorCode, Object...parameters) {
        this(errorCode, parameters);
        this.targetException = targetException;
    }

    public int getErrorCodeId() {
        return errorCodeId;
    }

    public Throwable getTargetException() {
        return targetException;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
