package com.bpm4sb.bpmengine.dao.model;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "BPM_TASKSTATUS")
public class TaskStatus {
    @Id @Column(name = "TASK_ID") String taskId;
    @Column(name = "TASKSTATE_ID") Integer taskStateId;
    @Column(name = "FROMDATE") Timestamp fromDate;
    @Column(name = "USER_ID") String userId;
    @Column(name = "THRUDATE") Timestamp thruDate;

    public TaskStatus() {
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskStateId() {
        return taskStateId;
    }

    public void setTaskStateId(Integer taskStateId) {
        this.taskStateId = taskStateId;
    }


    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getThruDate() {
        return thruDate;
    }

    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }    
}
