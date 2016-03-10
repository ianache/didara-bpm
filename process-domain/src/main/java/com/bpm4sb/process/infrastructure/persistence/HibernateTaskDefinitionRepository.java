package com.bpm4sb.process.infrastructure.persistence;

import com.bpm4sb.process.domain.model.IdentificationService;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinition;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionRepository;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import static com.bpm4sb.common.domain.model.AssertionConcern.*;

/**
 *
 * @author USUARIO
 */
@Transactional
public class HibernateTaskDefinitionRepository implements TaskDefinitionRepository {

    @Autowired private HibernateTransactionManager txManager;
    @Autowired private IdentificationService identificationService;

    @Override
    public String newTaskDefinition(String title, String instanceName, String description, String participantId) {
        TaskDefinition taskDef = new TaskDefinition();
        taskDef.setId(identificationService.getUniqueId());
        taskDef.setTitle(title);
        taskDef.setInstanceTitle(instanceName);
        taskDef.setParticipantId(participantId);
        getSession().persist(taskDef);
        return taskDef.getId();
    }

    @Override
    public List<TaskDefinition> queryTaskDefinitions() {
        return getSession()
                .createQuery("select def from TaskDefinition def order by def.title")
                .list();        
    }

    @Override
    public TaskDefinition queryTaskDefinitionById(String id) {
        Query q = getSession().createQuery("select def from TaskDefinition def where def.id=:_id");
        q.setParameter("_id", id);
        List<TaskDefinition> tasks = q.list();
        assertStateTrue(tasks.size() == 1, "No se ha encontrado la definicion de tarea");
        return tasks.get(0);
    }
    
    private Session getSession() {
        return txManager.getSessionFactory().getCurrentSession();
    }
}
