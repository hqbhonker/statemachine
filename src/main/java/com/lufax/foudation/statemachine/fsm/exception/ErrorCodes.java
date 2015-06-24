package com.lufax.foudation.statemachine.fsm.exception;

/**
 * Created by Administrator on 2015/6/24.
 */
public enum ErrorCodes {
    MISSING_ITEM_PROVIDER (10000, "couldn't initialize tree item provider, make sure it has been properly wired"),
    ILLEGAL_TYPE_CASTING (10001, "couldn't cast the instance from %s to %s"),
    INVOKE_PERSISTED_ENTITY_METHOD_ERROR (10002, "couldn't invoke method of PersistedEntity"),
    NOT_ALLOW_ACCESS_FIELD(10003, "wasn't allowed to get field '%s.%s'"),
    FIELD_NOT_FOUND(10004, "couldn't find field '%s.%s'"),
    NOT_ALLOW_ACCESS_METHOD(10005, "wasn't allowed to get method '%s.%s(%s)'"),
    METHOD_NOT_FOUND(10006, "couldn't find method '%s.%s(%s)'"),
    CONSTRUCT_NEW_INSTANCE_ERROR(10007, "couldn't construct new '%s' with args %s"),
    CANNOT_GET_FIELD_VALUE(10008, "couldn't get '%s'"),
    CANNOT_SET_FIELD_VALUE(10009, "couldn't set '%s' to '%s'"),
    METHOD_NULL(10010, "method is null"),
    FIELD_NULL(10011, "field is null"),
    METHOD_INVOKE_ERROR(10012, "couldn't invoke '%s' with %s on %s: %s"),
    CONSTRUCTOR_NOT_FOUND(10013, "couldn't find constructor of '%s' with parameter typs '%s'"),
    ILLEGAL_CLASS_NAME(10014, "illegal class name"),
    CLASS_NOT_FOUND(10015, "class '%s' not found"),
    METHOD_UNEXPECTED_PARAMETERS(10016, "Method requires unexpected parameters"),
    FSM_TRANSITION_ERROR(10017, "Transition from '%s'  on '%s'  " +
            "when invoking action '%s' caused exception '%s'"),

    STATEMACHINE_MODEL_OUTDATED(10018,"StateMachine( bizType: '%s', bizRefNo: '%s' ) is running,can not be triggered again "),
    ILLEGAL_DESC_STATE(10019,"illegal desc state of  '%s' "),

    ILLEGAL_DECISCITION_ACTION_DEF(10020,"you have to define only one isDecisition=true Action when  from  '%s'  state on event  '%s'"),
    ILLEGAL_TRANSIITION_DEF(10021,"source state '%s' trigger by event: '%s' must have only one transition"),
    NO_FINAL_STATE_DEF(10022,"StateMachine [bizType: '%s'] must have final state"),
    NO_INIT_STATE_DEF(100223,"StateMachine [bizType: '%s'] must have one init state"),
    // reserved error code from 10000-19999
    INTERNAL_ERROR (19998, "internal error"),
    UNEXPECTED_ERROR (19999, "unexpected error. Please submit a issue");

    private final int code;

    private final String description;

    private ErrorCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}

