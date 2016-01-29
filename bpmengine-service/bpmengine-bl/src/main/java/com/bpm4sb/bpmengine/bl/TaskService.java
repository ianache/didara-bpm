package com.bpm4sb.bpmengine.bl;

/**
 *
 * @author USUARIO
 */
public interface TaskService {
    /**
     * Realizar la creacion de una instancia para la especificación de tarea
     * provista.
     * 
     * @param taskDefId
     * @param xmlPayload
     * @param userName
     * @return 
     */
    public String createTask(String taskDefId, String xmlPayload, String userName);
}
