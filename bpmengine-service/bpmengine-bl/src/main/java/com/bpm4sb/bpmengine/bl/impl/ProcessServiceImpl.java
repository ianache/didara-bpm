package com.bpm4sb.bpmengine.bl.impl;

import com.bpm4sb.bpmengine.bl.DidaraBPMInfrastructure;
import com.bpm4sb.bpmengine.bl.ProcessDefinitionNotValidExpception;
import com.bpm4sb.bpmengine.bl.ProcessService;
import com.bpm4sb.bpmengine.bl.ProcessSpecificationNotExistException;
import com.bpm4sb.bpmengine.bl.model.Activity;
import com.bpm4sb.bpmengine.bl.model.EventNode;
import com.bpm4sb.bpmengine.bl.model.FlowNode;
import com.bpm4sb.bpmengine.dao.PersistenceManager;
import com.bpm4sb.bpmengine.dao.model.BusinessProcess;
import com.bpm4sb.bpmengine.dao.model.BusinessProcessDefinition;
import java.util.Calendar;
import java.util.UUID;
import javax.persistence.EntityManager;
import com.bpm4sb.bpmengine.bl.model.Process;
import com.bpm4sb.bpmengine.bl.model.SequenceFlow;
import com.bpm4sb.bpmengine.bl.model.WorkNode;
import com.bpm4sb.bpmn.TActivity;
import com.bpm4sb.bpmn.TCollaboration;
import com.bpm4sb.bpmn.TDefinitions;
import com.bpm4sb.bpmn.TEndEvent;
import com.bpm4sb.bpmn.TFlowElement;
import com.bpm4sb.bpmn.TFlowNode;
import com.bpm4sb.bpmn.TParticipant;
import com.bpm4sb.bpmn.TProcess;
import com.bpm4sb.bpmn.TRootElement;
import com.bpm4sb.bpmn.TSequenceFlow;
import com.bpm4sb.bpmn.TStartEvent;
import com.bpm4sb.bpmn.TUserTask;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.bpm4sb.bpmengine.bl.executor.FlowNodeExecutor;
import com.bpm4sb.bpmengine.bl.model.UserTaskNode;

/**
 *
 * @author Ilver
 */
public class ProcessServiceImpl implements ProcessService {
    private DidaraBPMInfrastructure infra = null;

    private HashMap<String, Process> processCatalog = new HashMap<String, Process>();
    private EntityManager em = null;

    public ProcessServiceImpl(DidaraBPMStandaloneInfrastructure infra) {
        em = PersistenceManager.INSTANCE.getEntityManager();
        setInfrastructure(infra);
    }    
    
    @Override
    public void start(String processDefId, String inputData, String userName) throws ProcessSpecificationNotExistException {
        em.getTransaction().begin();
        
        // Determinamos la especificación del proceso a ser instanciado
        Query q = em.createQuery("select p from BusinessProcessDefinition p where p.id = :theId");
        q.setParameter("theId", processDefId);
        List rs = q.getResultList();
        assert rs.size() > 0 : String.format("Process Definition Not Found for %s", processDefId); 
        
        BusinessProcessDefinition bpd = (BusinessProcessDefinition) rs.get(0);
        Process p = processCatalog.get(bpd.getId());
        if(p == null) {
            p = buildProcessFromXmlBPMN( bpd.getDefinition() );
            processCatalog.put(bpd.getId(), p);
        }

        BusinessProcess bp = createAndSaveNewProcess(bpd, inputData);
        
        em.getTransaction().commit();

        // Coloca el proceso en la cola para su ejecución
        execute( bp, inputData, userName);

        if(em.getTransaction().isActive()) {
            PersistenceManager.INSTANCE.close();
        }
        
    }

    private BusinessProcess createAndSaveNewProcess(BusinessProcessDefinition bpd, String inputData) {
        BusinessProcess bp = new BusinessProcess();
        bp.setCreatedOn(new Date(Calendar.getInstance().getTimeInMillis()));
        bp.setId(UUID.randomUUID().toString());
        bp.setProcessDefId(bpd.getId());
        em.persist(bp);
        return bp;
    }

    @Override
    public String deployProcess(String bpmnXmlDefinition) throws ProcessDefinitionNotValidExpception {

        Process p = buildProcessFromXmlBPMN(bpmnXmlDefinition);

        BusinessProcessDefinition bpd = new BusinessProcessDefinition();
        bpd.setId(UUID.randomUUID().toString());
        bpd.setName(p.getName());
        bpd.setDefinition(bpmnXmlDefinition);

        // Se realiza la carga de la información del modelo BPMN.
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();
        em.persist(bpd);
        em.getTransaction().commit();
        
        for(FlowNode fn: p.getFlowNodes().values()) {
            if(fn instanceof UserTaskNode) {
                UserTaskNode node = (UserTaskNode) fn;
                infra.getTaskService().deployTask( node.getId(), node.getName() );
            }
        }

        PersistenceManager.INSTANCE.close();

        processCatalog.put(p.getId(), p);

        return bpd.getId();
    }

    private Process buildProcessFromXmlBPMN(String xmlDefinition) {
        Process p = null;

        JAXBContext jbctx;
        try {
            jbctx = JAXBContext.newInstance("com.bpm4sb.bpmn");
            Unmarshaller um = jbctx.createUnmarshaller();

            InputStream is = new ByteArrayInputStream(xmlDefinition.getBytes());
            JAXBElement<TDefinitions> obj = (JAXBElement<TDefinitions>) um.unmarshal(is);
            assert (obj != null) : "Invalid BPMN processing";

            TDefinitions def = obj.getValue();

            // Load all definitions colaborations
            HashMap<String, TParticipant> mapIdToParticipant = 
                    new HashMap<String, TParticipant>();
            for(JAXBElement<? extends TRootElement> e: def.getRootElement()) {
                if(e.getValue() instanceof TCollaboration) {
                    TCollaboration c = (TCollaboration) e.getValue();
                    for(TParticipant part: c.getParticipant()) {
                        mapIdToParticipant.put(part.getProcessRef().getLocalPart(), part);
                    }
                }
            }
            
            // Load all process definitions
            for (JAXBElement<? extends TRootElement> e : def.getRootElement()) {
                if (e.getValue() instanceof TProcess) {
                    TProcess xmlProcess = (TProcess) e.getValue();
                    String name = mapIdToParticipant.get(xmlProcess.getId()).getName();
                    
                    p = new Process( xmlProcess.getId(), name );
                    p.setIsExecutable(xmlProcess.isIsExecutable());
                    
                    // Iterar por todos los elementos que forman parte
                    // del proceso
                    for(JAXBElement<? extends TFlowElement> fe: xmlProcess.getFlowElement()) {
                        if (fe.getValue() instanceof TStartEvent) {
                            TStartEvent node = (TStartEvent) fe.getValue();
                            EventNode en = new EventNode();
                            en.setId(node.getId());
                            en.setName( node.getName() );
                            p.getFlowNodes().put(en.getId(), en);
                            p.setStartEvent(en);
                            // TODO: Se debe diferenciar por los diferentes tipos                            
                        } else if(fe.getValue() instanceof TEndEvent) {
                            TEndEvent node = (TEndEvent) fe.getValue();
                            EventNode en = new EventNode();
                            en.setId(node.getId());
                            en.setName( node.getName() );
                            p.getFlowNodes().put(en.getId(), en);
                            // TODO: Se debe diferenciar por los diferentes tipos                                                        
                        } else if(fe.getValue() instanceof TUserTask) {
                            TUserTask node = (TUserTask) fe.getValue();
                            WorkNode wn = new WorkNode();
                            wn.setId(node.getId());
                            wn.setName( node.getName() );
                            p.getFlowNodes().put(wn.getId(), wn);
                            // TODO: Se debe diferenciar por los diferentes tipos   
                            System.out.println(String.format("Load Task Definition for: %s (%s)", wn.getName(), wn.getId()));
                        } else if(fe.getValue() instanceof TActivity) {
                            TActivity node = (TActivity) fe.getValue();
                            Activity an = new Activity();
                            an.setId(node.getId());
                            an.setName(node.getName());
                            p.getFlowNodes().put(an.getId(), an);
                        }
                    }

                    // Procesar todas las secuencias del flujo para poder vincular
                    // a todos los nodos del flujo
                    for(JAXBElement<? extends TFlowElement> fe: xmlProcess.getFlowElement()) {
                        if(fe.getValue() instanceof TSequenceFlow) {
                            TSequenceFlow sf = (TSequenceFlow) fe.getValue();
                            TFlowNode source = (TFlowNode) sf.getSourceRef();
                            TFlowNode target = (TFlowNode) sf.getTargetRef();

                            FlowNode fromNode = p.getFlowNodes().get(source.getId() );
                            FlowNode toNode = p.getFlowNodes().get( target.getId() );
                            
                            SequenceFlow flow = new SequenceFlow( fromNode, toNode, sf.getId() );
                            fromNode.getOutgoings().add(flow);
                            toNode.getIncomings().add(flow);
                        }                            
                    }
                    
                    break;
                }
            }

        } catch (JAXBException ex) {
            Logger.getLogger(ProcessServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AssertionError ex) {
            Logger.getLogger(ProcessServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    @Override
    public String loadProcessesFromMdr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Se realiza la ejecución de una instancia para el proceso de negocio
     * @param p 
     * @param inputData Datos de entrada en formato <b>JSON</b>.
     */
    private void execute(BusinessProcess pi, String inputData, String userName) {
        
        Process pd = processCatalog.get(pi.getProcessDefId());
        assert pd != null : 
                String.format("Process Definition (%s) Not found for Process Instance (%s)",
                        pi.getProcessDefId(),
                        pi.getId());
        
        executeFromCurrentNode( pd.getStartEvent(), pi, userName );        
    }
        
    private void executeFromCurrentNode(FlowNode currentFlowNode, BusinessProcess pi, String userName) {
        try {
            Boolean res = true;
            while(res) {
                String className = String.format("%s.impl.%sExecutor",
                    FlowNodeExecutor.class.getPackage().getName(),
                    currentFlowNode.getClass().getSimpleName());

                Class c = Class.forName(className);
                FlowNodeExecutor executor = (FlowNodeExecutor) c.newInstance();
                executor.setInfrastructure(infra);

                res = executor.execute( currentFlowNode, pi, userName );
                if(res) {
                // Se evaluan todas las salidas del nodo actual para seleccionar
                // el flujo de salida correcto.
                    currentFlowNode = executor.getNextFlowNode( currentFlowNode, pi, userName );
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProcessServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ProcessServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ProcessServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;
    }

    @Override
    public void setInfrastructure(DidaraBPMInfrastructure infra) {
        this.infra = infra;
    }

    @Override
    public DidaraBPMInfrastructure getInfrastructure() {
        return infra;
    }
}
