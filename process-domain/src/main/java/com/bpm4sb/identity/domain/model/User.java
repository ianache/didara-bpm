package com.bpm4sb.identity.domain.model;

import com.bpm4sb.common.domain.model.DomainEventPublisher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ianache
 */
public final class User extends IdentityEntity {
    private String login;
    private String fullName;
    private Boolean active;
    private List<Membership> memberships = new ArrayList<>();

    public User() {
        super();
    }

    public User(String login, String fullName, Boolean active) {
        setLogin(login);
        setFullName(fullName);
        setActive(active);
    }    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        DomainEventPublisher
                .instance()
                .publish(new UserActivationChanged(active, login));
        this.active = active;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

}
