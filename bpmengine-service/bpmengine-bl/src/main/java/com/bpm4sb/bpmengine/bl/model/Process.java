package com.bpm4sb.bpmengine.bl.model;

import java.util.HashMap;

/**
 *
 * @author USUARIO
 */
public class Process {
    private String id;
    private String name;
    private Boolean isExecutable = false;
    
    private FlowNode startEvent = null;
    private HashMap<String, FlowNode> flowNodes = 
            new HashMap<String, FlowNode>();

    public Process() {
    }    

    public Process(String id) {
        this.id = id;
    }    

    public Process(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public FlowNode getStartEvent() {
        return startEvent;
    }

    public void setStartEvent(FlowNode startEvent) {
        this.startEvent = startEvent;
    }

    public HashMap<String, FlowNode> getFlowNodes() {
        return flowNodes;
    }

    public void setFlowNodes(HashMap<String, FlowNode> flowNodes) {
        this.flowNodes = flowNodes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsExecutable() {
        return isExecutable;
    }

    public void setIsExecutable(Boolean isExecutable) {
        this.isExecutable = isExecutable;
    }

}
