package com.bpm4sb.bpmengine.bl.model;

/**
 *
 * @author USUARIO
 */
public class SequenceFlow extends FlowElement {

    public SequenceFlow(String nodeId) {
        super(nodeId);
    }

    public SequenceFlow() {
    }
    
    public SequenceFlow(FlowNode from, FlowNode to, String id) {
        setFrom(from);
        setTo(to);
        setNodeId(id);
    }
}
