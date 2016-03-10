package com.bpm4sb.identity.domain.model;

/**
 *
 * @author ianache
 */
public class IdentityEntity {
    private String id;
    private String name;

    public IdentityEntity() {
        super();
    }

    public IdentityEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }        
}
