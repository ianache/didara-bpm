package com.bpm4sb.bpmengine.bl.model;

/**
 *
 * @author USUARIO
 */
public class GatewayNode extends FlowNode {

    @Override
    public Boolean waitProcessing() {
        return true;
    }    
}
