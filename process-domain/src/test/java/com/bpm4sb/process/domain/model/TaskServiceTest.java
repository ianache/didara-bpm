package com.bpm4sb.process.domain.model;

import com.bpm4sb.process.domain.model.task.TaskService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class TaskServiceTest extends CommonTest {
    @Autowired TaskService taskService;
    
    @Test public void testActivateTask() {
        taskService.activate("1");
    }
    
    @Test public void testClaim() {
        taskService.claim("1");
    }
    
    @Test public void testComplete() {
        taskService.complete("1", "");
    }
}
