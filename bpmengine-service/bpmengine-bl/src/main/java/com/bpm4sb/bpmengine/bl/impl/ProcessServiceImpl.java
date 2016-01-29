package com.bpm4sb.bpmengine.bl.impl;

import com.bpm4sb.bpmengine.bl.ProcessDefinitionNotValidExpception;
import com.bpm4sb.bpmengine.bl.ProcessService;
import com.bpm4sb.bpmengine.bl.ProcessSpecificationNotExistException;
import com.bpm4sb.bpmengine.dao.PersistenceManager;
import com.bpm4sb.bpmengine.dao.model.BusinessProcess;
import com.bpm4sb.bpmengine.dao.model.BusinessProcessDefinition;
import java.util.Calendar;
import java.util.UUID;
import javax.persistence.EntityManager;

/**
 *
 * @author Ilver
 */
public class ProcessServiceImpl implements ProcessService {

    @Override
    public String start(String processDefId, String startMessage) throws ProcessSpecificationNotExistException {
        BusinessProcess bp = new BusinessProcess();
        bp.setCreatedOn(Calendar.getInstance().getTime());
        bp.setId(UUID.randomUUID().toString());
        bp.setProcessDefId(processDefId);        

        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();        
        em.persist(bp);        
        em.getTransaction().commit();
        PersistenceManager.INSTANCE.close();
        
        return bp.getId();
    }

    @Override
    public String loadProcessDefinition(String bpmnXmlDefinition) throws ProcessDefinitionNotValidExpception {
        BusinessProcessDefinition bpd = new BusinessProcessDefinition();
        bpd.setId(UUID.randomUUID().toString());
        bpd.setName( "" );
        bpd.setDefinition(bpmnXmlDefinition);
        
        // Se realiza la carga de la información del modelo BPMN.
        
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();
        em.persist(bpd);        
        em.getTransaction().commit();
        
        PersistenceManager.INSTANCE.close();
                
        return bpd.getId();
    }
}
