package com.bpm4sb.process.domain.model;

import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class TaskDefinitionServiceTest extends CommonTest {
    @Autowired TaskDefinitionService taskDefinitionService;
       
    @Test public void testNewTaskDefinition() {
        String taskDefId =
            taskDefinitionService.newTaskDefinition("Aprove deliverable", 
                    "Aprove deliverable", 
                    "Aprove the deliverable", 
                    "Manager");
        assertTrue(!"".equals(taskDefId));
    }    
}
