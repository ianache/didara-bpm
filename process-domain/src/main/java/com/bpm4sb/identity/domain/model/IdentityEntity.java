package com.bpm4sb.identity.domain.model;

/**
 *
 * @author ianache
 */
public class IdentityEntity {
    private String id;

    public IdentityEntity() {
        super();
    }

    public IdentityEntity(String id) {
        this.id = id;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
