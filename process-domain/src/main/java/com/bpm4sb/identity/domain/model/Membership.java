package com.bpm4sb.identity.domain.model;

/**
 *
 * @author ianache
 */
public class Membership {
    private User user;
    private Group group;
    private Boolean active;

    public Membership() {
    }

    public Membership(User user, Group group, Boolean active) {
        this.user = user;
        this.group = group;
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }    
}
