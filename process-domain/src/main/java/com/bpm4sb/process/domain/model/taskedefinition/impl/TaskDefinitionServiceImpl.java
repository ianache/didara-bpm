package com.bpm4sb.process.domain.model.taskedefinition.impl;

import com.bpm4sb.process.domain.model.participant.Participant;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionRepository;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import static com.bpm4sb.common.domain.model.AssertionConcern.*;
import com.bpm4sb.process.domain.model.participant.ParticipantRepository;

/**
 *
 * @author ianache
 */
public class TaskDefinitionServiceImpl implements TaskDefinitionService {
    @Autowired TaskDefinitionRepository taskDefinitionRepository;
    @Autowired ParticipantRepository participantRepository;

    public TaskDefinitionServiceImpl() {
        super();
    }
    
    @Override
    public String newTaskDefinition(String name, String instanceName, String description,
        String participantName) {
        
        Participant participant = 
                participantRepository.queryParticipantByName(participantName);
        assertStateTrue(participant != null, "No existe el participante");
        
        String taskDefId =
            taskDefinitionRepository.newTaskDefinition(name, 
                    instanceName, 
                    description,
                    participant.getId());
        return taskDefId;
    }

    @Override
    public String newParticipant(String name, String description) {
        Participant participant = 
                participantRepository.queryParticipantByName(name);
        assertStateTrue(participant != null, "El participante ya existe");
        return participantRepository.newParticipant(name, description);
    }
}
