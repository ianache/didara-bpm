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
     * @param startMessage
     * @return
     * @throws ProcessSpecificationNotExistException 
     */
    public String start(String processDefId, String startMessage) throws ProcessSpecificationNotExistException;
    
    /**
     * Esta operacion realiza la carga de la definicion de un proceso de negocio sobre el motor de procesos de
     * negocio.
     * 
     * @param bpmnXmlDefinition
     * @return
     * @throws ProcessDefinitionNotValidExpception 
     */
    public String loadProcessDefinition(String bpmnXmlDefinition) throws ProcessDefinitionNotValidExpception;
}
