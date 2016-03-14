package com.bpm4sb.process.domain.model.task.event;

import com.bpm4sb.common.domain.model.DomainEvent;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ianache
 */
public class TaskCreated implements DomainEvent {
    private final int version;
    private final Date occuredOn;
    private String taskId;
    private String taskName;
    private String taskInputData;
    private String owner;
    
    public TaskCreated(String taskId, String taskName, String taskInputData, String owner) {
        this.version = 1;
        this.occuredOn = Calendar.getInstance().getTime();
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskInputData = taskInputData;
        this.owner = owner;
    }

    @Override
    public int eventVersion() {
        return version;
    }

    @Override
    public Date occuredOn() {
        return occuredOn;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskInputData() {
        return taskInputData;
    }

    public void setTaskInputData(String taskInputData) {
        this.taskInputData = taskInputData;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }       
}
