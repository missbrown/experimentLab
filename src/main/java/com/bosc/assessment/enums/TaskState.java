package com.bosc.assessment.enums;

public enum TaskState {
    WAIT(0, "未开始"),
    EXEC(10, "运行中"),
    SUCCESS(20, "成功"),
    FAIL(30, "失败"),
    ABORT(40, "终止");

    private int state;
    private String desc;

    TaskState(int state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
