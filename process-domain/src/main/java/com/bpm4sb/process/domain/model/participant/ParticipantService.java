package com.bpm4sb.process.domain.model.participant;

import java.util.List;

/**
 *
 * @author ianache
 */
public interface ParticipantService {
    /**
     * 
     * @param name
     * @param description
     * @return 
     */
    String newParticipant(String name, String description);
    /**
     * 
     * @param name
     * @return 
     */
    Participant queryParticipantByName(String name);
    /**
     * 
     * @param id
     * @return 
     */
    Participant queryParticipantById(String id);
    /**
     * Incorpora una nueva entidad de identidad al participante.
     * 
     * @param identityName
     * @param identityType 
     */
    //void addOrganizationalEntity(String identityName, IdentityType identityType);
    /**
     * 
     * @param participant 
     */
    void saveParticipant(Participant participant);
}
