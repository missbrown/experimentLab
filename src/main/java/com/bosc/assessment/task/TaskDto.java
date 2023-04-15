package com.bosc.assessment.task;

import java.util.Date;

public class TaskDto {

    private Long taskId;
    private String taskCode;
    private String taskName;
    private Integer frequency;
    private String groupName;
    private Long parentId;
    private String parentName;
    private Long instanceId;
    private Date taskDateStart;
    private Date taskDateEnd;
    private String taskDateStartStr;
    private String taskDateEndStr;
    private Date startTimeStart;
    private Date startTimeEnd;
    private String startTimeStartStr;
    private String startTimeEndStr;
    private Integer triggerType;
    private String opUserName;
    private Integer opType;
    private Integer opTaskId;
    private String creatorName;
    private String updateUserName;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }

    public Date getTaskDateStart() {
        return taskDateStart;
    }

    public void setTaskDateStart(Date taskDateStart) {
        this.taskDateStart = taskDateStart;
    }

    public Date getTaskDateEnd() {
        return taskDateEnd;
    }

    public void setTaskDateEnd(Date taskDateEnd) {
        this.taskDateEnd = taskDateEnd;
    }

    public String getTaskDateStartStr() {
        return taskDateStartStr;
    }

    public void setTaskDateStartStr(String taskDateStartStr) {
        this.taskDateStartStr = taskDateStartStr;
    }

    public String getTaskDateEndStr() {
        return taskDateEndStr;
    }

    public void setTaskDateEndStr(String taskDateEndStr) {
        this.taskDateEndStr = taskDateEndStr;
    }

    public Date getStartTimeStart() {
        return startTimeStart;
    }

    public void setStartTimeStart(Date startTimeStart) {
        this.startTimeStart = startTimeStart;
    }

    public Date getStartTimeEnd() {
        return startTimeEnd;
    }

    public void setStartTimeEnd(Date startTimeEnd) {
        this.startTimeEnd = startTimeEnd;
    }

    public String getStartTimeStartStr() {
        return startTimeStartStr;
    }

    public void setStartTimeStartStr(String startTimeStartStr) {
        this.startTimeStartStr = startTimeStartStr;
    }

    public String getStartTimeEndStr() {
        return startTimeEndStr;
    }

    public void setStartTimeEndStr(String startTimeEndStr) {
        this.startTimeEndStr = startTimeEndStr;
    }

    public Integer getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(Integer triggerType) {
        this.triggerType = triggerType;
    }

    public String getOpUserName() {
        return opUserName;
    }

    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getOpTaskId() {
        return opTaskId;
    }

    public void setOpTaskId(Integer opTaskId) {
        this.opTaskId = opTaskId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }
}
