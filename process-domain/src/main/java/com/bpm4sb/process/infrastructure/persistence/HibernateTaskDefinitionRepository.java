package com.bpm4sb.process.infrastructure.persistence;

import com.bpm4sb.process.domain.model.IdentificationService;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinition;
import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionRepository;
import java.util.List;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
//@Transactional
public class HibernateTaskDefinitionRepository extends HibernateBaseRepository 
        implements TaskDefinitionRepository {
    @Autowired private IdentificationService identificationService;

    @Override
    public String newTaskDefinition(String title, String instanceName, 
            String description, String participantId, String expExpression,
            Boolean skipable) {
        TaskDefinition taskDef = new TaskDefinition(identificationService.getUniqueId(),
                title, instanceName, participantId, skipable,expExpression, 3);
        session().persist(taskDef);
        return taskDef.getId();
    }

    @Override
    public List<TaskDefinition> queryTaskDefinitions() {
        return session()
                .createQuery("select def from TaskDefinition def order by def.title")
                .list();        
    }

    @Override
    public TaskDefinition queryTaskDefinitionById(String id) {
        Query q = session().createQuery("select def from TaskDefinition def where def.id=:_id");
        q.setParameter("_id", id);
        List<TaskDefinition> tasks = q.list();
        /*assertState(tasks.size() == 1, 
                MessageFormat.format("No se ha encontrado la definicion de tarea {0}", id));*/
        return tasks.isEmpty() ? null : tasks.get(0);
    }

    @Override
    public TaskDefinition queryTaskDefinitionByName(String taskName) {
        Query q = session().createQuery("select def from TaskDefinition def where def.title=:_title");
        q.setParameter("_title", taskName);
        List<TaskDefinition> tasks = q.list();
        return tasks.isEmpty() ? null : tasks.get(0);
    }
}