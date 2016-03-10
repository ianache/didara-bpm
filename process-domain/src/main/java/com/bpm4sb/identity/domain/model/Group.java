package com.bpm4sb.identity.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ianache
 */
public class Group extends IdentityEntity {
    private List<Membership> members;

    public Group() {
        super();
    }
    
    public Group(String id, String name) {
        super(id, name);        
    }

    public List<Membership> getMembers() {
        if(members == null) {
            this.members = new ArrayList<>();
        }
        return members;
    }

    public void setMembers(List<Membership> members) {
        this.members = members;
    }    
}
