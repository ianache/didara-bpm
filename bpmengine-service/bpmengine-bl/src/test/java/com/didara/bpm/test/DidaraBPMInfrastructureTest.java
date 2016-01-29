package com.didara.bpm.test;

import com.bpm4sb.bpmengine.bl.DidaraBPMInfrastructure;
import com.bpm4sb.bpmengine.bl.ProcessService;
import com.bpm4sb.bpmengine.bl.ProcessSpecificationNotExistException;
import com.bpm4sb.bpmengine.bl.TaskService;
import com.bpm4sb.bpmengine.bl.impl.DidaraBPMStandaloneInfrastructure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USUARIO
 */
public class DidaraBPMInfrastructureTest {
    DidaraBPMInfrastructure infra = new DidaraBPMStandaloneInfrastructure();
       
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        infra.startup();
    }
    
    @After
    public void tearDown() {
        infra.shutdown();
    }

    //@Test
    public void testStandalone() throws ProcessSpecificationNotExistException {
        // Se realiza la obtención del servicio de proceso para crear una instancia
        // del proceso. Se realiza el inicio de una instancia del proceso.
        ProcessService ps = infra.getProcessService();
        ps.start("helloworld", null);
    }
    
    @Test
    public void testTaskCreation() {
        TaskService ts = infra.getTaskService();
        ts.createTask("1111-1111-1111-1111", null, "ianache");
    }
}
