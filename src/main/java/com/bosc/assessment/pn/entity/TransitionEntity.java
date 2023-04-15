package com.bosc.assessment.pn.entity;

public class TransitionEntity {

    private long id;
    private long pnId;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
