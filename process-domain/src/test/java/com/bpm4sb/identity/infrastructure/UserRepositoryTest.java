package com.bpm4sb.identity.infrastructure;

import com.bpm4sb.identity.domain.model.User;
import com.bpm4sb.identity.domain.model.UserRepository;
import com.bpm4sb.process.domain.model.CommonTest;
import com.bpm4sb.process.domain.model.IdentificationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
public class UserRepositoryTest extends CommonTest {
    @Autowired 
    private UserRepository userRepository;
    @Autowired
    private IdentificationService identificationService;
    
    @Test
    public void testNewUser() {
        User user = new User();
        user.setActive(true);
        user.setId(identificationService.getUniqueId());
        user.setFullName("ILVER ANACHE PUPO");
        user.setLogin("ianache");
        user.setEmail("ianache@crossnet.ws");
        user.setPassword("welcome1");
        userRepository.add(user);
    }
    
    @Test
    public void testQueryByName() {
        assertNotNull(userRepository.queryByName("ianache"));
    }
}
