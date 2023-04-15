package com.bosc.assessment.pn;

import java.util.List;

public class Place {

    private Long id;
    private Long pnId;
    private String name;
    private List<Long> nextTransitions;
    private int tokenNum;

    public void output() {
        this.tokenNum -= 1;
    }

    public void input() {
        this.tokenNum += 1;
    }

    public void setTokenNum(int tokenNum) {
        this.tokenNum= tokenNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPnId() {
        return pnId;
    }

    public void setPnId(Long pnId) {
        this.pnId = pnId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasToken() {
        return tokenNum > 0;
    }

    public List<Long> getNextTransitions() {
        return nextTransitions;
    }

    public void setNextTransitions(List<Long> nextTransitions) {
        this.nextTransitions = nextTransitions;
    }

}
