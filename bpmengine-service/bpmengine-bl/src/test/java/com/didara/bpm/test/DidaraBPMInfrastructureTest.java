package com.didara.bpm.test;

import com.bpm4sb.bpmengine.bl.DidaraBPMInfrastructure;
import com.bpm4sb.bpmengine.bl.ProcessDefinitionNotValidExpception;
import com.bpm4sb.bpmengine.bl.ProcessService;
import com.bpm4sb.bpmengine.bl.ProcessSpecificationNotExistException;
import com.bpm4sb.bpmengine.bl.TaskService;
import com.bpm4sb.bpmengine.bl.impl.DidaraBPMStandaloneInfrastructure;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

    @Test
    public void testStartProcess() throws ProcessSpecificationNotExistException {
        // Se realiza la obtención del servicio de proceso para crear una instancia
        // del proceso. Se realiza el inicio de una instancia del proceso.
        ProcessService ps = infra.getProcessService();
        ps.start("fd23d5cd-3e6c-409e-b6cf-9eb7d7859397", null, "ianache");
    }
    
    //@Test
    public void testTaskCreation() {
        TaskService ts = infra.getTaskService();
        ts.createTask("1111-1111-1111-1111", null, "ianache");
    }
    
    //@Test
    public void testJson() throws JSONException {
        com.bpm4sb.bpmengine.bl.model.Process p =
                new com.bpm4sb.bpmengine.bl.model.Process("121212","Hola Mundo");
        /*Gson gson = new Gson();
        String result = gson.toJson(p);
        System.out.println(result);
        
        com.bpm4sb.bpmengine.bl.model.Process p2 = 
                gson.fromJson(result, com.bpm4sb.bpmengine.bl.model.Process.class);

        System.out.println( p2.getName() ); */
        
        
        JSONObject jo = new JSONObject(p);
        String result = jo.toString();
        System.out.println(result);
        
        /*JSONObject jo = new JSONObject(result);
        System.out.println("Name: " + jo.getString("name"));*/
        
        JSONObject jo2 = new JSONObject(result);
        System.out.println("Name: " + jo2.getString("name"));
    }
    
    //@Test
    public void testDeployProcess() {
        try {
            infra.getProcessService().deployProcess("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<bpmn:definitions xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" id=\"Definitions_1\" targetNamespace=\"http://bpmn.io/schema/bpmn\">\n" +
                    "  <bpmn:collaboration id=\"Collaboration_0jk5agh\">\n" +
                    "    <bpmn:participant id=\"Participant_04n7a3y\" name=\"Hola Mundo\" processRef=\"Process_1\" />\n" +
                    "  </bpmn:collaboration>\n" +
                    "  <bpmn:process id=\"Process_1\" isExecutable=\"false\">\n" +
                    "    <bpmn:startEvent id=\"StartEvent_1\" name=\"Inicio\">\n" +
                    "      <bpmn:outgoing>SequenceFlow_0bpxsbn</bpmn:outgoing>\n" +
                    "    </bpmn:startEvent>\n" +
                    "    <bpmn:endEvent id=\"EndEvent_1g7vu7y\" name=\"Fin\">\n" +
                    "      <bpmn:incoming>SequenceFlow_17e7bv2</bpmn:incoming>\n" +
                    "    </bpmn:endEvent>\n" +
                    "    <bpmn:sequenceFlow id=\"SequenceFlow_0bpxsbn\" sourceRef=\"StartEvent_1\" targetRef=\"UserTask_1wrcp9u\" />\n" +
                    "    <bpmn:sequenceFlow id=\"SequenceFlow_17e7bv2\" sourceRef=\"UserTask_1wrcp9u\" targetRef=\"EndEvent_1g7vu7y\" />\n" +
                    "    <bpmn:userTask id=\"UserTask_1wrcp9u\" name=\"Mostrar Mensaje Hola Mundo\">\n" +
                    "      <bpmn:incoming>SequenceFlow_0bpxsbn</bpmn:incoming>\n" +
                    "      <bpmn:outgoing>SequenceFlow_17e7bv2</bpmn:outgoing>\n" +
                    "    </bpmn:userTask>\n" +
                    "  </bpmn:process>\n" +
                    "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n" +
                    "    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Collaboration_0jk5agh\">\n" +
                    "      <bpmndi:BPMNShape id=\"Participant_04n7a3y_di\" bpmnElement=\"Participant_04n7a3y\">\n" +
                    "        <dc:Bounds x=\"142\" y=\"10\" width=\"600\" height=\"250\" />\n" +
                    "      </bpmndi:BPMNShape>\n" +
                    "      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_1\">\n" +
                    "        <dc:Bounds x=\"201\" y=\"109\" width=\"36\" height=\"36\" />\n" +
                    "        <bpmndi:BPMNLabel>\n" +
                    "          <dc:Bounds x=\"174\" y=\"145\" width=\"90\" height=\"20\" />\n" +
                    "        </bpmndi:BPMNLabel>\n" +
                    "      </bpmndi:BPMNShape>\n" +
                    "      <bpmndi:BPMNEdge id=\"SequenceFlow_0bpxsbn_di\" bpmnElement=\"SequenceFlow_0bpxsbn\">\n" +
                    "        <di:waypoint xsi:type=\"dc:Point\" x=\"237\" y=\"127\" />\n" +
                    "        <di:waypoint xsi:type=\"dc:Point\" x=\"264\" y=\"127\" />\n" +
                    "        <bpmndi:BPMNLabel>\n" +
                    "          <dc:Bounds x=\"206\" y=\"117\" width=\"90\" height=\"20\" />\n" +
                    "        </bpmndi:BPMNLabel>\n" +
                    "      </bpmndi:BPMNEdge>\n" +
                    "      <bpmndi:BPMNShape id=\"EndEvent_1g7vu7y_di\" bpmnElement=\"EndEvent_1g7vu7y\">\n" +
                    "        <dc:Bounds x=\"396\" y=\"109\" width=\"36\" height=\"36\" />\n" +
                    "        <bpmndi:BPMNLabel>\n" +
                    "          <dc:Bounds x=\"369\" y=\"145\" width=\"90\" height=\"20\" />\n" +
                    "        </bpmndi:BPMNLabel>\n" +
                    "      </bpmndi:BPMNShape>\n" +
                    "      <bpmndi:BPMNEdge id=\"SequenceFlow_17e7bv2_di\" bpmnElement=\"SequenceFlow_17e7bv2\">\n" +
                    "        <di:waypoint xsi:type=\"dc:Point\" x=\"364\" y=\"127\" />\n" +
                    "        <di:waypoint xsi:type=\"dc:Point\" x=\"396\" y=\"127\" />\n" +
                    "        <bpmndi:BPMNLabel>\n" +
                    "          <dc:Bounds x=\"335\" y=\"117\" width=\"90\" height=\"20\" />\n" +
                    "        </bpmndi:BPMNLabel>\n" +
                    "      </bpmndi:BPMNEdge>\n" +
                    "      <bpmndi:BPMNShape id=\"UserTask_1wrcp9u_di\" bpmnElement=\"UserTask_1wrcp9u\">\n" +
                    "        <dc:Bounds x=\"264\" y=\"87\" width=\"100\" height=\"80\" />\n" +
                    "      </bpmndi:BPMNShape>\n" +
                    "    </bpmndi:BPMNPlane>\n" +
                    "  </bpmndi:BPMNDiagram>\n" +
                    "</bpmn:definitions>");
        } catch (ProcessDefinitionNotValidExpception ex) {
            Logger.getLogger(DidaraBPMInfrastructureTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
