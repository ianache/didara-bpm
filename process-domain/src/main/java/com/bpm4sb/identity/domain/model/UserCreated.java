package com.bpm4sb.identity.domain.model;

import com.bpm4sb.common.domain.model.DomainEvent;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ianache
 */
public class UserCreated implements DomainEvent {
    private int version;
    private Date occuredOn;
    private String login;
    private String email;

    public UserCreated() {
        super();
    }

    public UserCreated(String login, String email) {
        this.login = login;
        this.email = email;
        this.version = 1;
        this.occuredOn = Calendar.getInstance().getTime();
    }
     
    @Override
    public int eventVersion() {
        return this.version;
    }

    @Override
    public Date occuredOn() {
        return this.occuredOn;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getOccuredOn() {
        return occuredOn;
    }

    public void setOccuredOn(Date occuredOn) {
        this.occuredOn = occuredOn;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
