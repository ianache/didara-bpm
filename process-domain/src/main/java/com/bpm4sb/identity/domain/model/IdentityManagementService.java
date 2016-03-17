package com.bpm4sb.identity.domain.model;

/**
 *
 * @author ianache
 */
public interface IdentityManagementService {
    /**
     * Se realiza el registro de un nuevo usuario.
     * 
     * @param login
     * @param fullName
     * @param email
     * @param password 
     */
    void addUser(String login, String fullName, String email, String password);
    
    /**
     * Adiciona un nuevo usuario y se emite un correo electrónico con indicaciones
     * para realizar el cambio de la contraseña proporcionada.
     * 
     * @param login
     * @param fullName
     * @param email 
     */
    void addUser(String login, String fullName, String email);
    
    /**
     * 
     * @param login
     * @param enablement 
     */
    void enableUser(String login, Boolean enablement);
    
    /**
     * 
     * @param name
     * @param description
     */
    void addGroup(String name, String description);    
}
