package com.bpm4sb.bpmengine.bl.impl;

import com.bpm4sb.bpmengine.bl.ProcessService;
import com.bpm4sb.bpmengine.bl.ProcessSpecificationNotExistException;
import com.bpm4sb.bpmengine.dao.PersistenceManager;
import com.bpm4sb.bpmengine.dao.model.BusinessProcess;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Ilver
 */
public class ProcessServiceImpl implements ProcessService {

    @Override
    public Integer start(Integer processDefId, String startMessage) throws ProcessSpecificationNotExistException {
        Integer id = null;
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        BusinessProcess bp = new BusinessProcess();
        bp.setCreatedOn(Calendar.getInstance().getTime());
        bp.setId(1);
        bp.setProcessDefId(2);
        
        em.getTransaction().begin();
        
        em.persist(bp);
        
        em.getTransaction().commit();
        em.close();
        
        PersistenceManager.INSTANCE.close();
        
        return id;
    }
    
}
