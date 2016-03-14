package com.bpm4sb.process.domain.model.task;

/**
 *
 * @author ianache
 */
public class TaskAttachment {
    private String id;
    private Content content;

    public TaskAttachment() {
        super();
    }

    public TaskAttachment(String id, Content content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
    
    
}
