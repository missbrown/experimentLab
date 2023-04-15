package com.bosc.assessment.task;

public class TaskDependency {
    private long taskId;
    private long parentId;

    public TaskDependency(long taskId, long parentId) {
        this.taskId = taskId;
        this.parentId = parentId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
