package com.bpm4sb.process.domain.model.taskedefinition;

import java.util.List;

/**
 *
 * @author ianache
 */
public interface TaskDefinitionRepository {
    /**
     * Se realiza el registro de una nueva definición de tarea de usuario.
     * 
     * @param name
     * @param instanceName
     * @param description
     * @param participantId
     * @param expExpression
     * @param skipable
     * @return 
     */
    public String newTaskDefinition(String name, String instanceName, String description,
        String participantId, String expExpression, Boolean skipable);
    
    /**
     * 
     * @return 
     */
    public List<TaskDefinition> queryTaskDefinitions();
    
    /**
     * 
     * @param id
     * @return 
     */
    TaskDefinition queryTaskDefinitionById(String id);

    /**
     * 
     * @param taskName
     * @return 
     */
    TaskDefinition queryTaskDefinitionByName(String taskName);
}
