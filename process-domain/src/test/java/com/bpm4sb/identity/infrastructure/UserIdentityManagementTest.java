package com.bpm4sb.identity.infrastructure;

import com.bpm4sb.identity.domain.model.IdentityManagementService;
import com.bpm4sb.process.domain.model.CommonTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class UserIdentityManagementTest extends CommonTest {
    @Autowired 
    private IdentityManagementService identityManagementService;
    
    /*@Test
    public void testNewUser() {
        identityManagementService.addUser("ianache", "ILVER ANACHE", "ianache@crossnet.ws");
    }*/
    
    @Test
    public void testNewGroup() {
       identityManagementService.addGroup("administrators", "Administradores");
    }
}
