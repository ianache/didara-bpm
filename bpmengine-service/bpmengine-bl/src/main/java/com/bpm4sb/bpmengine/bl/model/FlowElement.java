package com.bpm4sb.bpmengine.bl.model;

/**
 *
 * @author ianache
 */
public abstract class FlowElement {
    private FlowNode from = null;
    private FlowNode to = null;
    private String nodeId;

    public FlowElement(String nodeId) {
        this.nodeId = nodeId;
    }

    public FlowElement() {
    }    

    public FlowNode getFrom() {
        return from;
    }

    public void setFrom(FlowNode from) {
        this.from = from;
    }

    public FlowNode getTo() {
        return to;
    }

    public void setTo(FlowNode to) {
        this.to = to;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }
       
}
