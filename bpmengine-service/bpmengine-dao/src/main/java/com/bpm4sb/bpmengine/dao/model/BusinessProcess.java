package com.bpm4sb.bpmengine.dao.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BPM_PROCESSINST")
public class BusinessProcess {
    @Id @GeneratedValue String id;
    private @Column(name = "PROCESSDEF_ID") Integer processDefId;
    private @Column(name = "CREATEDON") Date createdOn;

    public BusinessProcess() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProcessDefId() {
        return processDefId;
    }

    public void setProcessDefId(Integer processDefId) {
        this.processDefId = processDefId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}
