package com.bpm4sb.process.domain.model.task;

import java.util.Date;

/**
 *
 * @author ianache
 */
public class TaskComment {
    private String id;
    private String comment;
    private Date date;
    private String userName;

    public TaskComment() {
        super();
    }

    public TaskComment(String id, String comment, Date date, String userName) {
        this.id = id;
        this.comment = comment;
        this.date = date;
        this.userName = userName;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }       
}
