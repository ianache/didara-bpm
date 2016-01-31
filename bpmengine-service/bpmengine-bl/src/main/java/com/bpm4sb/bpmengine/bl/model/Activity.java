package com.bpm4sb.bpmengine.bl.model;

/**
 *
 * @author USUARIO
 */
public class Activity extends FlowNode {    

    @Override
    public Boolean waitProcessing() {
        return false;
    }
}
