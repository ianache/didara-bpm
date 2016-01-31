package com.bpm4sb.bpmengine.bl.model;

/**
 *
 * @author USUARIO
 */
public class EventNode extends FlowNode {

    @Override
    public Boolean waitProcessing() {
        return !getOutgoings().isEmpty();
    }
    
}
