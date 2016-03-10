package com.bpm4sb.process.domain.model.participant;

import java.util.List;

/**
 *
 * @author ianache
 */
public interface ParticipantRepository {
    /**
     * 
     * @param id
     * @return 
     */
    Participant queryParticipantById(String id);
    
    /**
     * 
     * @return 
     */
    List<Participant> queryAllParticipant();
    
    /**
     * Se realiza la incorporacion de un nuevo participante al que se le 
     * asocian las definiciones de las tareas.
     * 
     * @param name
     * @param description
     * @return 
     */
    String newParticipant(String name, String description);

    /**
     * 
     * @param participantName
     * @return 
     */
    Participant queryParticipantByName(String participantName);
}
