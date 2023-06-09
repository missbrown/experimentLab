package com.bosc.assessment.enums;

public enum TaskOpType {
    CREATE(10, "创建"),
    RETRY(20, "重试"),
    STOP(30, "终止");
    private int type;
    private String desc;

    TaskOpType(int type, String desc) {
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
