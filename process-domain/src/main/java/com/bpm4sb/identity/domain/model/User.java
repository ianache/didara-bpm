package com.bpm4sb.identity.domain.model;

import com.bpm4sb.common.domain.model.DomainEventPublisher;
import com.bpm4sb.process.domain.model.DomainRegistry;
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
    private String password;
    private String email;
    private final List<Membership> memberships = new ArrayList<>();

    public User() {
        super();
    }

    public User(String login, String fullName, String email, Boolean active) {
        super();
        this.login = login;
        this.fullName = fullName;
        this.active = active;
        this.email = email;
        
        DomainEventPublisher
                .instance()
                .publish(new UserCreated(login, email));
    }    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
