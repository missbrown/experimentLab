package com.bosc.assessment.pn.entity;

public class PNMarkEntity {
    private long id;
    private long pnId;
    private long placeId;
    private int tokenNum;

    public int getTokenNum() {
        return tokenNum;
    }

    public void setTokenNum(int tokenNum) {
        this.tokenNum = tokenNum;
    }

    public long getPnId() {
        return pnId;
    }

    public void setPnId(long pnId) {
        this.pnId = pnId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }
}
