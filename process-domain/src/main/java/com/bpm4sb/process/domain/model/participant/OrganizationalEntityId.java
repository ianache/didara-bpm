package com.bpm4sb.process.domain.model.participant;

import java.io.Serializable;

/**
 *
 * @author ianache
 */
public class OrganizationalEntityId implements Serializable {
    private Participant participant;
    private String identityName;

    public OrganizationalEntityId() {
    }

    public OrganizationalEntityId(Participant participant, String identityName) {
        this.participant = participant;
        this.identityName = identityName;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }
}
