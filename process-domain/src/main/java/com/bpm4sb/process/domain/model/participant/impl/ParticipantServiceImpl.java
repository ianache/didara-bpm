package com.bpm4sb.process.domain.model.participant.impl;

import com.bpm4sb.process.domain.model.participant.Participant;
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
    public Participant queryParticipantByName(String name) {
        return participantRepository.queryParticipantByName(name);
    }

    @Override
    public Participant queryParticipantById(String id) {
        return participantRepository.queryParticipantById(id);
    }

    @Override
    public String newParticipant(String name, String description) {
        return participantRepository.newParticipant(name, description);
    }    

    @Override
    public void saveParticipant(Participant participant) {
        participantRepository.save(participant);
    }
}
