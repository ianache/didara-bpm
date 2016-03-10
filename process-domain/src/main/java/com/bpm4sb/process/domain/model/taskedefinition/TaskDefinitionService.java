package com.bpm4sb.process.domain.model.taskedefinition;

/**
 *
 * @author ianache
 */
public interface TaskDefinitionService {
    /**
     * Realiza el registro de una nueva definicion de tareas en el repositorio
     * de metadatos (MDS).
     * 
     * @param name
     * @param instanceName
     * @param description
     * @param participantName
     * @return 
     */
    String newTaskDefinition(String name, String instanceName, String description, String participantName);
    
    /**
     * 
     * @param name
     * @param description
     * @return 
     */
    String newParticipant(String name, String description);
}
