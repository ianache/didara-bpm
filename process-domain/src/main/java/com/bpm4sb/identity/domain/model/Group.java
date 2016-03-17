package com.bpm4sb.identity.domain.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author ianache
 */
public class Group extends IdentityEntity {
    private Group parentGroup;
    private String name;
    private String description;
    private Collection<Group> childGroups = new ArrayList<>();;
    private Collection<Membership> contains = new ArrayList<>();

    public Group() {
        super();
    }
    
    public Group(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public Collection<Group> getChildGroups() {
        return childGroups;
    }

    public void setChildGroups(Collection<Group> childGroups) {
        this.childGroups = childGroups;
    }

    public Collection<Membership> getContains() {
        return contains;
    }

    public void setContains(Collection<Membership> contains) {
        this.contains = contains;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
