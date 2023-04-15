package com.bosc.assessment.task;

import java.util.Date;

public class TaskLog {
    private long id;
    private long opUserId;
    private int opType;
    private long opTaskId;
    private Date opTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(long opUserId) {
        this.opUserId = opUserId;
    }

    public int getOpType() {
        return opType;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }

    public long getOpTaskId() {
        return opTaskId;
    }

    public void setOpTaskId(long opTaskId) {
        this.opTaskId = opTaskId;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }
}
