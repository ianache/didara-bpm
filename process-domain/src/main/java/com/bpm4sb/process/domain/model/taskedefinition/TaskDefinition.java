package com.bpm4sb.process.domain.model.taskedefinition;

/**
 *
 * @author ianache
 */
public class TaskDefinition {
    private String id;
    private String title;
    private String instanceTitle;
    private String participantId;
    private Boolean skipable;
    private String expirationExpression;
    private Integer priority;

    public TaskDefinition() {
        super();
    }

    public TaskDefinition(String id, String title, String instanceTitle, 
            String participantId, Boolean skipable, String expirationExpression, 
            Integer priority) {
        this.id = id;
        this.title = title;
        this.instanceTitle = instanceTitle;
        this.participantId = participantId;
        this.skipable = skipable;
        this.expirationExpression = expirationExpression;
        this.priority = priority;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstanceTitle() {
        return instanceTitle;
    }

    public void setInstanceTitle(String instanceTitle) {
        this.instanceTitle = instanceTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }    

    public Boolean isSkipable() {
        return skipable;
    }

    public void setSkipable(Boolean skipable) {
        this.skipable = skipable;
    }

    public String getExpirationExpression() {
        return expirationExpression;
    }

    public void setExpirationExpression(String expirationExpression) {
        this.expirationExpression = expirationExpression;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    
}
