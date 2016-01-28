package com.bpm4sb.bpmengine.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "BPM_PROCESSDEF")
public class BusinessProcessDefinition {
    @Id private String id;
    
    @Column(name = "NAME")
    private String name;

    public BusinessProcessDefinition() {
    }

    public BusinessProcessDefinition(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
