package com.bpm4sb.bpmengine.bl.impl;

import com.bpm4sb.bpmengine.bl.DidaraBPMInfrastructure;
import com.bpm4sb.bpmengine.bl.ProcessService;
import com.bpm4sb.bpmengine.bl.TaskService;

/**
 *
 * @author USUARIO
 */
public class DidaraBPMStandaloneInfrastructure implements DidaraBPMInfrastructure {
    private ProcessService processService;
    private TaskService taskService;

    @Override
    public void startup() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.processService = new ProcessServiceImpl(this);
        this.taskService = new TaskServiceImpl(this);
    }

    @Override
    public void shutdown() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessService getProcessService() {
        return this.processService;
    }

    @Override
    public TaskService getTaskService() {
        return this.taskService;
    }
}
