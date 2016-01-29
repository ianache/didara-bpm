package com.bpm4sb.bpmengine.bl.impl;

import com.bpm4sb.bpmengine.dao.model.TaskStatus;
import com.bpm4sb.bpmengine.bl.TaskService;
import com.bpm4sb.bpmengine.dao.PersistenceManager;
import com.bpm4sb.bpmengine.dao.model.Task;
import com.bpm4sb.bpmengine.dao.model.TaskDefinition;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
public class TaskServiceImpl implements TaskService {

    @Override
    public String createTask(String taskDefId, String xmlPayload, String userName) {
        String taskId = null;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();
        
        // Se obtiene la definicion de la tarea para la que se requiere crear la 
        // instancia.
        Query res = em.createQuery("select t from TaskDefinition t where t.id = :taskId");
        res.setParameter("taskId", taskDefId);
        List r = res.getResultList();
        TaskDefinition td = (r.size() != 0) ? (TaskDefinition)r.get(0) : null;
        
        if(td != null) {
            
            Task t = new Task();
            t.setId(UUID.randomUUID().toString());
            t.setTaskDefId(td.getId());
            em.persist(t);
            
            // Save the state to Started
            TaskStatus ts = new TaskStatus();
            ts.setFromDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            ts.setTaskStateId(1); /* Estado Inicial: Created */
            ts.setTaskId(UUID.randomUUID().toString());
            ts.setThruDate(null);
            ts.setUserId(userName);
            em.persist(ts);
        }
        
        em.getTransaction().commit();
        PersistenceManager.INSTANCE.close();
        
        return taskId;
    }    
}
