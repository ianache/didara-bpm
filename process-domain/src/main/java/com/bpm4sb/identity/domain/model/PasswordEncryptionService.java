package com.bpm4sb.identity.domain.model;

/**
 *
 * @author ianache
 */
public interface PasswordEncryptionService {
    /**
     * 
     * @param clearPassword
     * @return 
     */
    String encrypt(String clearPassword);
}
