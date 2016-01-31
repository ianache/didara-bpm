package com.bpm4sb.bpmengine.bl.executor.impl;

import com.bpm4sb.bpmengine.bl.DidaraBPMInfrastructure;
import com.bpm4sb.bpmengine.bl.executor.FlowNodeExecutor;
import com.bpm4sb.bpmengine.bl.model.FlowNode;
import com.bpm4sb.bpmengine.dao.model.BusinessProcess;

/**
 *
 * @author USUARIO
 */
public class GatewayNodeExecute extends FlowNodeExecutor {

    public GatewayNodeExecute() {
    }
    
    public GatewayNodeExecute(DidaraBPMInfrastructure infra) {
        setInfrastructure(infra);
    }
    
    @Override
    public Boolean execute(FlowNode currentFlowNode, BusinessProcess pi, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
