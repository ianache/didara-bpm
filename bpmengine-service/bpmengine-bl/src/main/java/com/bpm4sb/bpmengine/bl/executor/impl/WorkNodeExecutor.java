package com.bpm4sb.bpmengine.bl.executor.impl;

import com.bpm4sb.bpmengine.bl.DidaraBPMInfrastructure;
import com.bpm4sb.bpmengine.bl.executor.FlowNodeExecutor;
import com.bpm4sb.bpmengine.bl.model.FlowNode;
import com.bpm4sb.bpmengine.bl.model.WorkNode;
import com.bpm4sb.bpmengine.dao.model.BusinessProcess;

/**
 *
 * @author USUARIO
 */
public class WorkNodeExecutor extends FlowNodeExecutor {

    public WorkNodeExecutor() {
    }
    
    public WorkNodeExecutor(DidaraBPMInfrastructure infra) {
        setInfrastructure(infra);
    }
    
    @Override
    public Boolean execute(FlowNode currentFlowNode, BusinessProcess pi, String userName) {
        // Se raliza la ejecución de una tarea de usuario
        // con el motor de tareas humadas
        WorkNode node = (WorkNode) currentFlowNode;
        getInfrastructure().getTaskService().createTask(node.getId(), null, userName);
        return false;
    }   
    
}
