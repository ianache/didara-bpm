package com.bpm4sb.process.domain.model.task;

/**
 *
 * @author ianache
 */
public class TaskState {
    private Status id;
    private String title;
    private String ationsAllowed;

    public TaskState() {
    }

    public TaskState(Status id, String title, String ationsAllowed) {
        this.id = id;
        this.title = title;
        this.ationsAllowed = ationsAllowed;
    }

    public Status getId() {
        return id;
    }

    public void setId(Status id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAtionsAllowed() {
        return ationsAllowed;
    }

    public void setAtionsAllowed(String ationsAllowed) {
        this.ationsAllowed = ationsAllowed;
    }        
}
