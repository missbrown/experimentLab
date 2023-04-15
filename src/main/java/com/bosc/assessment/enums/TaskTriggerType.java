package com.bosc.assessment.enums;

public enum TaskTriggerType {
    AUTO(0, "自动"),
    MANNUAL(1, "手动");

    private int type;
    private String desc;

    TaskTriggerType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
