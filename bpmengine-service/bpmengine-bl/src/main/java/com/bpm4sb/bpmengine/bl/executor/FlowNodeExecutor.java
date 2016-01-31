package com.bpm4sb.bpmengine.bl.executor;

import com.bpm4sb.bpmengine.bl.DidaraBPMInfrastructure;
import com.bpm4sb.bpmengine.bl.ProcessService;
import com.bpm4sb.bpmengine.bl.model.FlowElement;
import com.bpm4sb.bpmengine.bl.model.FlowNode;
import com.bpm4sb.bpmengine.bl.model.GatewayNode;
import com.bpm4sb.bpmengine.dao.model.BusinessProcess;

/**
 *
 * @author USUARIO
 */
public abstract class FlowNodeExecutor {
    DidaraBPMInfrastructure infrastructure = null;
    
    /**
     * 
     * @param currentFlowNode
     * @param pi
     * @param userName
     * @return <b>true></b> si continua con siguiente procesamiento, <b>false</b> si se detiene
     */
    public abstract Boolean execute( FlowNode currentFlowNode, BusinessProcess pi, String userName );
    
    public DidaraBPMInfrastructure getInfrastructure() {
        return infrastructure;
    }

    public void setInfrastructure(DidaraBPMInfrastructure infrastructure) {
        this.infrastructure = infrastructure;
    }    

    public FlowNode getNextFlowNode(FlowNode currentFlowNode, BusinessProcess pi, String userName) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(FlowElement fn: currentFlowNode.getOutgoings()) {
            // Se debe evaluar cada una de las salidas posibles, cuando el nodo
            // es un gateway exclusivo o inclusivo y además es de tipo "fork"
            if(currentFlowNode instanceof GatewayNode) {
                
                if(currentFlowNode.getOutgoings().size() > 1) {
                    // Es un gateway tipo "fork".
                    return currentFlowNode.getOutgoings().get(0).getTo();
                } else if(currentFlowNode.getIncomings().size() > 1) {
                    // Es un gateway de tipo "Join", entonces se deberá
                    // esperar hasta que todos los tokens del "Fork" previo
                    // arriven a este punto.
                    return currentFlowNode.getOutgoings().get(0).getTo();
                }
                
            } else return fn.getTo();
        }
        return currentFlowNode;
    }
}
