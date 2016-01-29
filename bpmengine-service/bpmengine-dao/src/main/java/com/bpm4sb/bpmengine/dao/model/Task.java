package com.bpm4sb.bpmengine.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "BPM_TASK")
public class Task {
    @Id @Column(name="ID") String id;
    @Column(name="TASKDEF_ID") String taskDefId;
    @Column(name = "DATA") String data;
    @Column(name = "ERROR") String faultData;
    @Column(name = "ASSIGNEE") String assignee;
    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskDefId() {
        return taskDefId;
    }

    public void setTaskDefId(String taskDefId) {
        this.taskDefId = taskDefId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFaultData() {
        return faultData;
    }

    public void setFaultData(String faultData) {
        this.faultData = faultData;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
        
}
