package com.bosc.assessment.pn.entity;

public class PNIOEntity {
    private long id;
    private long pnId;
    private long transitionId;
    private long placeId;
    private int ioType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPnId() {
        return pnId;
    }

    public void setPnId(long pnId) {
        this.pnId = pnId;
    }

    public long getTransitionId() {
        return transitionId;
    }

    public void setTransitionId(long transitionId) {
        this.transitionId = transitionId;
    }

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public int getIoType() {
        return ioType;
    }

    public void setIoType(int ioType) {
        this.ioType = ioType;
    }
}

