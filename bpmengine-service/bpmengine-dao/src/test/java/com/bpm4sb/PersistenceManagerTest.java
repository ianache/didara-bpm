package com.bpm4sb;

import com.bpm4sb.bpmengine.dao.PersistenceManager;
import com.bpm4sb.bpmengine.dao.model.BusinessProcessDefinition;
import java.util.UUID;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ilver
 */
public class PersistenceManagerTest {
    
    public PersistenceManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //@Test
    public void accessTest() {
        BusinessProcessDefinition pd = new BusinessProcessDefinition(UUID.randomUUID().toString(),"Hello World");        
        
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();
     
        em.persist(pd);
        em.getTransaction().commit();
        em.close();
        PersistenceManager.INSTANCE.close();
    }
}
