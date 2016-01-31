package com.bpm4sb.bpmengine.bl;

public interface ProcessService {
    /**
     * Esta operacion permite realizar la creacion de una instancia para una 
     * especificacion de procesos de negocio. Si la especificacion no existe
     * se genera la excepcion <b>ProcessSpecificationNotExistException</b>, en
     * caso contrario, se devuelve el identificador de la nueva instancia del 
     * proceso.
     * 
     * @param processDefId
     * @param inputData
     * @param userName
     * @throws ProcessSpecificationNotExistException 
     */
    public void start(String processDefId, String inputData, String userName) throws ProcessSpecificationNotExistException;
    
    /**
     * Esta operacion realiza la carga de la definicion de un proceso de negocio sobre el motor de procesos de
     * negocio.
     * 
     * @param bpmnXmlDefinition
     * @return
     * @throws ProcessDefinitionNotValidExpception 
     */
    public String deployProcess(String bpmnXmlDefinition) throws ProcessDefinitionNotValidExpception;
    
    /**
     * Se realiza la carga de todos los procesos que se encuentran registrados
     * en la base de datos de <b>MDR</b>.
     * 
     * @return 
     */
    public String loadProcessesFromMdr();
    
    public void setInfrastructure(DidaraBPMInfrastructure infra);
    public DidaraBPMInfrastructure getInfrastructure();
    
}
