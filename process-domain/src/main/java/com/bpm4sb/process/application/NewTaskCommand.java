package com.bpm4sb.process.application;

/**
 *
 * @author ianache
 */
public class NewTaskCommand {
    private ExecutionContext ctx;
    private String taskDefId;
    private String inputData;
    
    public NewTaskCommand() {
        super();
    }

    public NewTaskCommand(ExecutionContext ctx, String taskDefId, String inputData) {
        this.ctx = ctx;
        this.taskDefId = taskDefId;
        this.inputData = inputData;
    }

    public ExecutionContext getCtx() {
        return ctx;
    }

    public void setCtx(ExecutionContext ctx) {
        this.ctx = ctx;
    }

    public String getTaskDefId() {
        return taskDefId;
    }

    public void setTaskDefId(String taskDefId) {
        this.taskDefId = taskDefId;
    }        

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }    
}
