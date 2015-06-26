package com.lufax.foudation.statemachine.fsm.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2015/6/22.
 */
public class StateMachineSerialModel  implements Serializable {
    private String id;
    private String stateMachineModelId;
    private String sourceState;
    private String descState;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    public StateMachineSerialModel() {
        this.id= UUID.randomUUID().toString();
    }
    public String getId() {
        return id;
    }

    public String getStateMachineModelId() {
        return stateMachineModelId;
    }

    public void setStateMachineModelId(String stateMachineModelId) {
        this.stateMachineModelId = stateMachineModelId;
    }

    public String getSourceState() {
        return sourceState;
    }

    public void setSourceState(String sourceState) {
        this.sourceState = sourceState;
    }

    public String getDescState() {
        return descState;
    }

    public void setDescState(String descState) {
        this.descState = descState;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String toString(){
       return   ToStringBuilder.reflectionToString(this);
    }
}
