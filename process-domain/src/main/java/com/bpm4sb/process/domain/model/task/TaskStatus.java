package com.bpm4sb.process.domain.model.task;

import java.util.Date;

/**
 *
 * @author ianache
 */
public class TaskStatus {
    private TaskInstance parentTask;
    private Status stateId;
    private Date fromDate;
    private Date thruDate;
    private String userName;

    public TaskStatus() {
        super();
    }

    public TaskStatus(TaskInstance parentTask, Status stateId, Date fromDate, Date thruDate, String userName) {
        this.parentTask = parentTask;
        this.stateId = stateId;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
        this.userName = userName;
    }
        
    public TaskInstance getParentTask() {
        return parentTask;
    }

    public void setParentTask(TaskInstance parentTask) {
        this.parentTask = parentTask;
    }

    public Status getStateId() {
        return stateId;
    }

    public void setStateId(Status stateId) {
        this.stateId = stateId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getThruDate() {
        return thruDate;
    }

    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
