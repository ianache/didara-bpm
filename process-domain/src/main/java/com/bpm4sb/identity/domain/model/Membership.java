package com.bpm4sb.identity.domain.model;

/**
 *
 * @author ianache
 */
public class Membership {
    private String userId;
    private String groupId;
    private Boolean active;

    public Membership() {
    }

    public Membership(String userId, String groupId, Boolean active) {
        this.userId = userId;
        this.groupId = groupId;
        this.active = active;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }    
}
