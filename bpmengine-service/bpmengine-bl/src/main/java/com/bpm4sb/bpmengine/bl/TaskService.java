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
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void activate(String taskId, String userName);
    
    /**
     * 
     * @param taskId
     * @param userName
     * @param newAssignee 
     */
    public void forward(String taskId, String userName, String newAssignee);
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void revoke(String taskId, String userName);
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void claim(String taskId, String userName);
    
    /**
     * 
     * @param taskId
     * @param userName
     * @param newAssignee 
     */
    public void delegate(String taskId, String userName, String newAssignee);
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void start(String taskId, String userName);
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void stop(String taskId, String userName);
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void suspend(String taskId, String userName);
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void resume(String taskId, String userName);
    
    /**
     * 
     * @param taskId
     * @param userName
     * @param outcome 
     */
    public void complete(String taskId, String userName, String outcome);
    
    /**
     * 
     * @param taskId
     * @param userName
     * @param faultData 
     */
    public void fault(String taskId, String userName, String faultData);
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void error(String taskId, String userName);
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void exit(String taskId, String userName);
    
    /**
     * 
     * @param taskId
     * @param userName 
     */
    public void skip(String taskId, String userName);
    
    public void setInfrastructure(DidaraBPMInfrastructure infra);
    public DidaraBPMInfrastructure getInfrastructure();

    public void deployTask(String id, String name);
}
