package com.lufax.foudation.statemachine.fsm.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2015/6/22.
 */
public class StateMachineModel implements Serializable {
    private String id;
    private String bizRefNo;
    private String bizType;
    private String currentState;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private boolean isDone;
    private int version;
    private int attempCount;
    public StateMachineModel (){
        this.id= UUID.randomUUID().toString();
    }
    public StateMachineModel(String bizType,String bizRefNo){
        this();
        this.bizRefNo=bizRefNo;
        this.bizType=bizType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getBizRefNo() {
        return bizRefNo;
    }

    public void setBizRefNo(String bizRefNo) {
        this.bizRefNo = bizRefNo;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getAttempCount() {
        return attempCount;
    }

    public void setAttempCount(int attempCount) {
        this.attempCount = attempCount;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
    public String toString(){
        return   ToStringBuilder.reflectionToString(this);
    }



}
