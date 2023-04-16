package com.bosc.assessment.dto;

public class TagOwnerDto {
    private String ownerName;
    private int count;

    public TagOwnerDto() {}

    public TagOwnerDto(String ownerName, int count) {
        this.ownerName = ownerName;
        this.count = count;
    }

    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
