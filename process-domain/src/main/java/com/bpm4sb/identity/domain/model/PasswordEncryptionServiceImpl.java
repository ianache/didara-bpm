package com.bpm4sb.identity.domain.model;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author ianache
 */
public class PasswordEncryptionServiceImpl implements PasswordEncryptionService {
    private Boolean useStrong = false;

    public PasswordEncryptionServiceImpl() {
        super();
    }

    public PasswordEncryptionServiceImpl(Boolean useStrong) {
        this.useStrong = useStrong;
    }
    
    @Override
    public String encrypt(String clearPassword) {
        return (useStrong) ? strongEncrypt(clearPassword) : weakEncrypt(clearPassword);
            
    }
    
    private String weakEncrypt(String clearPassword) {
        BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();
        return encryptor.encryptPassword(clearPassword);
    }
    
    
    private String strongEncrypt(String clearPassword) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        return passwordEncryptor.encryptPassword(clearPassword);    
    }
}
