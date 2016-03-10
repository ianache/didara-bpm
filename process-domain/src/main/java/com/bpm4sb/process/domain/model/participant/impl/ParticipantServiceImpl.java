package com.bpm4sb.process.domain.model.participant.impl;

import com.bpm4sb.process.domain.model.participant.ParticipantRepository;
import com.bpm4sb.process.domain.model.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired 
    private ParticipantRepository participantRepository;

    @Override
    public String newParticipant(String name, String description) {
        return participantRepository.newParticipant(name, description);
    }
}
