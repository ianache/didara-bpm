package com.bpm4sb.process.application;

import com.bpm4sb.process.domain.model.CommonTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class TaskApplicationServiceTest extends CommonTest{
    @Autowired TaskApplicationService taskApplicationService;

    private ExecutionContext ctx;

    /**
     *
     */
    @Override
    @Before
    public void setUp() {
        ctx = new ExecutionContext();
        ctx.setUserName("ianache");
    }
    
    /*@Test public void testActivateTask() {
        ActivateCommand cmd = new ActivateCommand(ctx, "ianache");
        taskApplicationService.activate(cmd);
    }*/
    @Test
    public void newTask() {
        NewTaskCommand cmd = new NewTaskCommand(ctx, "442CD628-1A34-4296-ABFA-61C69F9FA8A8", "ianache");
        taskApplicationService.newTask(cmd);
    }
}
