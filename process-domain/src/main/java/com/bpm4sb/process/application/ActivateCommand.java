package com.bpm4sb.process.application;

import java.io.Serializable;

/**
 *
 * @author ianache
 */
public class ActivateCommand implements Serializable {
    private ExecutionContext ctx;
    private String taskId;

    public ActivateCommand() {
    }

    public ActivateCommand(ExecutionContext ctx, String taskId) {
        this.ctx = ctx;
        this.taskId = taskId;
    }

    public ExecutionContext getCtx() {
        return ctx;
    }

    public void setCtx(ExecutionContext ctx) {
        this.ctx = ctx;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }        
}
