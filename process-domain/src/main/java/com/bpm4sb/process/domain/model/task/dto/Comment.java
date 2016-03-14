package com.bpm4sb.process.domain.model.task.dto;

/**
 *
 * @author ianache
 */
public class Comment {
    private String id;
    private String comment;

    public Comment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }    
}
