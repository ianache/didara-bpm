package com.bpm4sb.process.infrastructure;

import com.bpm4sb.process.domain.model.CommonTest;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class TaskDefinitionRepositoryTest extends CommonTest {
    @Autowired TaskDefinitionRepository taskDefinitionRepository;
    
    @Test public void testQueryTaskDefinition() {
        //taskDefinitoinRepository.newTaskDefinition(null, null, null, null)
    }
    
    /*String participantId;
    @Test public void testNewParticipant() {
        participantId = 
            taskDefinitionRepository.newParticipant("ProjectManager", "Project Manager");
        assertTrue(!"".equals(participantId));
    }*/
    
    @Test public void testNewTaskDefinition() {
        String taskDefId =
            taskDefinitionRepository.newTaskDefinition("Aprove deliverable", 
                    "Aprove deliverable", 
                    "Aprove the deliverable", 
                    "5269A9EA-48A1-44F1-BCBB-954AAB8BEE58");
        assertTrue(!"".equals(taskDefId));
    }
    
}
