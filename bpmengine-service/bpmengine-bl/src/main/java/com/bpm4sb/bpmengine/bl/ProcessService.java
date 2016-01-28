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
    public Integer start(Integer processDefId, String startMessage) throws ProcessSpecificationNotExistException;
}
