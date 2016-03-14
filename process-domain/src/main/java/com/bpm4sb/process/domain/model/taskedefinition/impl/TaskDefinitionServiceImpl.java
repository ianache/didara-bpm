package com.bpm4sb.process.domain.model.taskedefinition.impl;

import com.bpm4sb.process.domain.model.participant.Participant;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionRepository;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import static com.bpm4sb.common.domain.model.AssertionConcern.*;
import com.bpm4sb.process.domain.model.participant.ParticipantService;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinition;
import java.text.MessageFormat;

/**
 *
 * @author ianache
 */
public class TaskDefinitionServiceImpl implements TaskDefinitionService {
    @Autowired TaskDefinitionRepository taskDefinitionRepository;
    @Autowired ParticipantService participantService;

    public TaskDefinitionServiceImpl() {
        super();
    }
    
    @Override
    public String newTaskDefinition(String name, String instanceName, String description,
        String participantName) {
        
        Participant participant = 
                participantService.queryParticipantByName(participantName);
        assertState(participant != null, 
                MessageFormat.format("No existe el participante {0}", participantName));
        
        String taskDefId =
            taskDefinitionRepository.newTaskDefinition(name, 
                    instanceName, 
                    description,
                    participant.getId(),
                    "1D",
                    false);
        return taskDefId;
    }

    @Override
    public TaskDefinition queryTaskDefinitionByName(String taskName) {
        return taskDefinitionRepository.queryTaskDefinitionByName(taskName);
    }

    @Override
    public TaskDefinition queryTaskDefinitionById(String taskDefId) {
        return taskDefinitionRepository.queryTaskDefinitionById(taskDefId);
    }
}
