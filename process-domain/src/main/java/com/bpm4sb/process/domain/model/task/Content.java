package com.bpm4sb.process.domain.model.task;

import java.util.Date;

/**
 *
 * @author ianache
 */
public class Content {
    private String id;
    private String fileName;
    private Date date;
    private byte[] data;
    private String contentType;

    public Content() {
    }

    public Content(String id, String fileName, Date date, byte[] data, String contentType) {
        this.id = id;
        this.fileName = fileName;
        this.date = date;
        this.data = data;
        this.contentType = contentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
}
