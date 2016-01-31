package com.bpm4sb.bpmengine.bl.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public abstract class FlowNode {
    private String id;
    private String name;
    
    private List<FlowElement> incomings = new ArrayList<FlowElement>();
    private List<FlowElement> outgoings = new ArrayList<FlowElement>();

    public List<FlowElement> getIncomings() {
        return incomings;
    }

    public void setIncomings(List<FlowElement> incomings) {
        this.incomings = incomings;
    }

    public List<FlowElement> getOutgoings() {
        return outgoings;
    }

    public void setOutgoings(List<FlowElement> outgoings) {
        this.outgoings = outgoings;
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
    
    public abstract Boolean waitProcessing();
    
}
