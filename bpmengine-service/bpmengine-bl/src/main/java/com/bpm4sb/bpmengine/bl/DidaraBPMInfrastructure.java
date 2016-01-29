package com.bpm4sb.bpmengine.bl;

/**
 *
 * @author USUARIO
 */
public interface DidaraBPMInfrastructure {
    /**
     * Esta operacion permite realizar el lanzamiento de una instancia de la
     * infraestructura BPM, con los diferentes servicios que lo componen. De
     * acuerdo con el tipo de infraestructura, la implementación de los servicios
     * se adecua al escenario de operacion.
     */
    public void startup();
    /**
     * Esta operacion permite realizar el apagado de todos los servicios de la
     * infraestructura BPM, preservando la integridad de todos los elementos
     * de la infraestructura.
     */
    public void shutdown();
    /**
     * Permite obtener el servicio de gestión de los procesos de negocio, atado
     * a la infraestructura.
     * 
     * @return 
     */
    public ProcessService getProcessService();
    
    /**
     * Permite obtener el servicio de gestion de las tareas de usuario, atado a
     * la infraestructura.
     * 
     * @return 
     */
    public TaskService getTaskService();
}
