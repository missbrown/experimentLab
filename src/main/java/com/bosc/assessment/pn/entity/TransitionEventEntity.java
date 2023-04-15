package com.bosc.assessment.pn.entity;

public class TransitionEventEntity {
    private long id;
    private long transitionId;
    private int eventCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTransitionId() {
        return transitionId;
    }

    public void setTransitionId(long transitionId) {
        this.transitionId = transitionId;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }
}
