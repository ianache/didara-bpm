package com.bpm4sb.bpmengine.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */
@Entity
@Table (name = "BPM_TASKDEF")
public class TaskDefinition {
    @Id @Column(name = "ID") String id;
    @Column(name = "NAME") String name;
    
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

    public TaskDefinition() {
    }  
    
}
