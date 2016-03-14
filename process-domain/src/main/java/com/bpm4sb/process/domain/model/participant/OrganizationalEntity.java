package com.bpm4sb.process.domain.model.participant;

/**
 *
 * @author ianache
 */
public class OrganizationalEntity {
    private OrganizationalEntityId id;
    private IdentityType identityType = IdentityType.User;  // U - User or G - Group

    public OrganizationalEntity() {
        super();
    }

    protected OrganizationalEntity(Participant participant, String identityName, IdentityType identityType) {
        this.id = new OrganizationalEntityId(participant, identityName);
        this.identityType = identityType;
    }

    public String getIdentityName() {
        return this.id.getIdentityName();
    }

    /*public Character getIdentityType() {
        return identityType.getType();
    }

    public void setIdentityType(Character identityType) {
        this.identityType.setType(identityType);
    }*/
    
    public Participant getParticipant() {
        return this.id.getParticipant();
    }

    public OrganizationalEntityId getId() {
        return id;
    }

    public void setId(OrganizationalEntityId id) {
        this.id = id;
    }

    /*public String getIdentityType() {
    return identityType;
    }
    public void setIdentityType(String identityType) {
    this.identityType = identityType;
    }*/
    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }   
}
