package com.bpm4sb.identity.domain.model;

import com.bpm4sb.common.domain.model.DomainEvent;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ianache
 */
public class UserActivationChanged implements DomainEvent {
    private int eventVersion;
    private Boolean active;
    private Date ocurredOn;
    private String username;

    public UserActivationChanged(Boolean active, String username) {
        this.eventVersion = 1;
        this.ocurredOn = Calendar.getInstance().getTime();
        this.active = active;
        this.username = username;
    }
    

    @Override
    public int eventVersion() {
        return this.eventVersion;
    }

    @Override
    public Date occuredOn() {
        return this.ocurredOn;
    }    

    public int getEventVersion() {
        return eventVersion;
    }

    public void setEventVersion(int eventVersion) {
        this.eventVersion = eventVersion;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getOcurredOn() {
        return ocurredOn;
    }

    public void setOcurredOn(Date ocurredOn) {
        this.ocurredOn = ocurredOn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
