package com.bpm4sb.process.domain.model.task;

import com.bpm4sb.common.domain.model.DomainEventPublisher;
import com.bpm4sb.process.domain.model.task.event.TaskCreated;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ianache
 */
public final class TaskInstance {
    private String id;
    private String title;
    private String taskDefinition;
    private String outcome;
    private String dataObject;
    private String assignee;
    private String owner;
    private Integer priority;
    private Date expirationDate;
    private List<TaskStatus> states = new ArrayList<>();

    public TaskInstance() {
        super();
    }

    public TaskInstance(String id, String title, String taskDefinition, 
            String outcome, String dataObject, String assignee, String owner) {
        this(id, title, taskDefinition, outcome, dataObject, assignee, 
            owner, 3);
    }
    
    public TaskInstance(String id, String title, String taskDefinition, 
            String outcome, String dataObject, String assignee, String owner,
            Integer priority) {
        this.id = id;
        this.title = title;
        this.taskDefinition = taskDefinition;
        this.outcome = outcome;
        this.dataObject = dataObject;
        this.assignee = assignee;
        this.owner = owner;
        this.priority = priority;
        this.expirationDate = null;
        
        this.newState(Status.Created, owner);
        
        DomainEventPublisher
            .instance()
            .publish(new TaskCreated(title, title, dataObject, owner));
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskDefinition() {
        return taskDefinition;
    }

    public void setTaskDefinitionId(String taskDefinition) {
        this.taskDefinition = taskDefinition;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getDataObject() {
        return dataObject;
    }

    public void setDataObject(String dataObject) {
        this.dataObject = dataObject;
    }

    public List<TaskStatus> getStates() {
        return states;
    }

    public void setStates(List<TaskStatus> states) {
        this.states = states;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }   
    
    public void changeState(Status newState, String userName) {
        TaskStatus status = newState(newState, userName);
        getStates().stream().forEach((TaskStatus e) -> e.setThruDate(status.getFromDate()));
        getStates().add(status);
    }
    
    private TaskStatus newState(Status newState, String userName) {
        Date now = Calendar.getInstance().getTime();
        return new TaskStatus(this, 
                newState, 
                now,
                null,
                userName);        
    }
}
