package com.bpm4sb.process.domain.model;

import com.bpm4sb.process.domain.model.participant.ParticipantService;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class ParticipantServiceTest extends CommonTest {
    @Autowired TaskDefinitionService taskDefinitionService;
    @Autowired ParticipantService participantService;
    
    @Test public void testNewParticipant() {
        participantService.newParticipant("Manager", "Project Manager");
    }

}
