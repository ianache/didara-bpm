package com.bpm4sb.process.application.impl;

import com.bpm4sb.process.application.ActivateCommand;
import com.bpm4sb.process.application.NewTaskCommand;
import com.bpm4sb.process.application.TaskApplicationService;
import com.bpm4sb.process.domain.model.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class TaskApplicationServiceImpl implements TaskApplicationService {
    @Autowired TaskService taskService;
    
    @Override
    public void activate(ActivateCommand cmd) {
        taskService.activate( cmd.getTaskId() );
    }

    @Override
    public void newTask(NewTaskCommand cmd) {
        taskService.newTask(cmd.getTaskDefId(), cmd.getInputData(), cmd.getCtx().getUserName());
    }
    
}
