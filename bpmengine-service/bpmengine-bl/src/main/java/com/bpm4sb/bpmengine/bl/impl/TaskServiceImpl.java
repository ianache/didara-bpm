package com.bpm4sb.bpmengine.bl.impl;

import com.bpm4sb.bpmengine.bl.DidaraBPMInfrastructure;
import com.bpm4sb.bpmengine.dao.model.TaskStatus;
import com.bpm4sb.bpmengine.bl.TaskService;
import com.bpm4sb.bpmengine.bl.TaskStateEnum;
import com.bpm4sb.bpmengine.dao.PersistenceManager;
import com.bpm4sb.bpmengine.dao.model.Task;
import com.bpm4sb.bpmengine.dao.model.TaskDefinition;
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
    DidaraBPMInfrastructure infra = null;
    private EntityManager em = null;
    
    public TaskServiceImpl(DidaraBPMStandaloneInfrastructure infra) {
        em = PersistenceManager.INSTANCE.getEntityManager();
    }
    
    @Override
    public String createTask(String taskDefId, String xmlPayload, String userName) {
        String taskId = null;
        Boolean newTx = !em.getTransaction().isActive();
        if(!em.getTransaction().isActive())
            em.getTransaction().begin();
        
        TaskDefinition td = findTaskDefinitionById(taskDefId);
        assert td != null;
        
        Task t = new Task();
        t.setId(UUID.randomUUID().toString());
        t.setTaskDefId(td.getId());
        em.persist(t);

        createNewState(t.getId(), TaskStateEnum.Created, userName, null);
        
        //changeState(t.getId(), userName, TaskStateEnum.Created);            
        
        em.getTransaction().commit();
        if(newTx) {
            PersistenceManager.INSTANCE.close();
        }
        
        return taskId;
    }    

    @Override
    public void activate(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forward(String taskId, String userName, String newAssignee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void revoke(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void claim(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegate(String taskId, String userName, String newAssignee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void suspend(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void complete(String taskId, String userName, String outcome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fault(String taskId, String userName, String faultData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exit(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void skip(String taskId, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Consultar el estado vigente de una tarea. Siempre el estado vigente es
     * aquel que tiene por fecha thruDate en nulo, pues aún no se ha salida de
     * el.
     * 
     * @param taskId
     * @return 
     */
    private TaskStatus findTaskCurrentStateByTaskId(String taskId) {
        Query q = em.createQuery("select ts from TaskStatus ts where ts.taskId = :theTaskId and ts.thruDate = null");
        q.setParameter("theTaskId", taskId);
        List res = q.getResultList();
        return (TaskStatus) ((!res.isEmpty()) ? res.get(0) : null);
    }

    private TaskDefinition findTaskDefinitionById(String taskDefId) {
        Query res = em.createQuery("select t from TaskDefinition t where t.id = :taskId");
        res.setParameter("taskId", taskDefId);
        List r = res.getResultList();
        TaskDefinition td = (r.size() != 0) ? (TaskDefinition)r.get(0) : null;
        return td;
    }

    /**
     * Permite cambiar el estado actual de una tarea al estado nuevo. Se debe
     * preservar la integridad en las transiciones entre los estados, de acuerdo
     * con el modelo de estados de una tarea conforme con el estandar.
     * 
     * @param taskId
     * @param userName
     * @param newState 
     */
    private void changeState(String taskId, String userName, TaskStateEnum newState) {
        TaskStatus current = findTaskCurrentStateByTaskId(taskId);
        Timestamp now = new Timestamp(Calendar.getInstance().getTime().getTime());
        
        // Si hay un estado actual, se debe salir del estado actual, antes
        // de registrar el nuevo estado.
        if(current != null) {
            current.setThruDate(now);
            em.persist(current);
        }
                
        createNewState(taskId, newState, userName, now);
    }

    /**
     * Se realiza la creacion de un estado completamente nuevo. Es útil para
     * cuando se crea inicialmente la tarea, o cuando se modifica el estado actual
     * de una tarea, previa verificacion de la consistencia en la transicion.
     * 
     * @param taskId
     * @param newState
     * @param userName 
     * @param now
     */
    private void createNewState(String taskId, TaskStateEnum newState, String userName, Timestamp now) {        
        TaskStatus ts = new TaskStatus();

        now = now == null ? new Timestamp(Calendar.getInstance().getTime().getTime()) : now;
        
        ts.setTaskStateId(newState.ordinal()); 
        ts.setTaskId(taskId);
        ts.setFromDate( now );
        ts.setThruDate(null);   /* Se debe modificar cuando se cambie el estado */
        ts.setUserId(userName);
        em.persist(ts);
    }

    @Override
    public void setInfrastructure(DidaraBPMInfrastructure infra) {
        this.infra = infra;
    }
    @Override
    public DidaraBPMInfrastructure getInfrastructure() {
        return infra;
    }

    @Override
    public void deployTask(String id, String name) {
        Boolean newTx = !em.getTransaction().isActive();
        if(!em.getTransaction().isActive())
            em.getTransaction().begin();
        
        TaskDefinition td = new TaskDefinition();
        td.setId(id);
        td.setName(name);
        
        em.persist(td);
        
        em.getTransaction().commit();
        if(newTx) {
            PersistenceManager.INSTANCE.close();
        }
    }
}
