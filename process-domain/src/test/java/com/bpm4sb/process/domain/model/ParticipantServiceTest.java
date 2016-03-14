package com.bpm4sb.process.domain.model;

import com.bpm4sb.process.domain.model.participant.IdentityType;
import com.bpm4sb.process.domain.model.participant.Participant;
import com.bpm4sb.process.domain.model.participant.ParticipantService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class ParticipantServiceTest extends CommonTest {
    @Autowired ParticipantService participantService;
    
    @Test public void testNewParticipant() {
        String id = participantService.newParticipant("Manager", "Project Manager");
        
        Participant participant = participantService.queryParticipantById(id);
        assertTrue("Tiene asignados", participant.getAssigments().isEmpty());
        participant.addAssigment("ianache", IdentityType.User);
        participant.addAssigment("administrators", IdentityType.Group);
        participantService.saveParticipant(participant);

       /* participant = participantService.queryParticipantById(id);
        assertTrue("No tiene asignados", !participant.getAssigments().isEmpty());       
        
        participant.removeAssigment("ianache");
        participantService.saveParticipant(participant);*/
    }

}
