package com.bpm4sb.process.infrastructure.persistence;

import com.bpm4sb.process.domain.model.IdentificationService;
import com.bpm4sb.process.domain.model.task.TaskInstance;
import com.bpm4sb.process.domain.model.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class HibernateTaskRepository extends HibernateBaseRepository implements TaskRepository {
    @Autowired private IdentificationService identificationService;
    
    /*@Override
    public String newTask(String taskName, String inputData, String userName) {
        TaskInstance task = new TaskInstance(
                identificationService.getUniqueId(),
                title);
        task.setAssignee(userName);
        task.setDataObject(inputData);
        task.setId();
        task.setOutcome(null);
        task.setOwner(userName);
        task.setTaskDefinitionId(taskName);
        return task.getId();
    }*/

    @Override
    public TaskInstance queryTaskById(String taskId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String newTask(String taskDefId, String title, String inputData, 
            String expirationExpression, String owner, Integer priority) {
        TaskInstance task = 
                new TaskInstance(identificationService.getUniqueId(),
                        title, 
                        taskDefId, 
                        null, 
                        inputData,
                        null, 
                        owner,  
                        priority);
        session().persist(task);
        return task.getId();
    }    
}
