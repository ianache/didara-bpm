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

    public TaskDefinition() {
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
}
