package com.bpm4sb.process.domain.model.task;

/**
 *
 * @author ianache
 */
public interface TaskRepository {
    /**
     * 
     * @param taskName
     * @param inputData
     * @param userName
     * @return 
     */
    //public String newTask(String taskName, String inputData, String userName);
    /**
     * 
     * @param taskId
     * @return 
     */
    public TaskInstance queryTaskById(String taskId);
    /**
     * 
     * @param taskDefId
     * @param title
     * @param inputData
     * @param expirationExpression
     * @param owner
     * @param priority
     * @return 
     */
    public String newTask(String taskDefId, String title, String inputData, 
            String expirationExpression, String owner, Integer priority);
    
}
