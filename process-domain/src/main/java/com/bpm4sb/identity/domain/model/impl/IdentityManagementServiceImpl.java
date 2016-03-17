package com.bpm4sb.identity.domain.model.impl;

import com.bpm4sb.common.domain.model.AssertionConcern;
import com.bpm4sb.identity.domain.model.Group;
import com.bpm4sb.identity.domain.model.GroupRepository;
import com.bpm4sb.identity.domain.model.IdentityManagementService;
import com.bpm4sb.identity.domain.model.PasswordEncryptionService;
import com.bpm4sb.identity.domain.model.User;
import com.bpm4sb.identity.domain.model.UserRepository;
import com.bpm4sb.process.domain.model.IdentificationService;
import java.text.MessageFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ianache
 */
@Transactional
public class IdentityManagementServiceImpl implements IdentityManagementService {
    @Autowired private IdentificationService identificationService;
    @Autowired private UserRepository userRepository;
    @Autowired private GroupRepository groupRepository;
    @Autowired private PasswordEncryptionService passwordEncryptionService;
    
    @Override
    public void addUser(String login, String fullName, String email, String password) {
        User user = new User(login, fullName, email, true/*always enabled*/);
        user.setId(identificationService.getUniqueId());
        user.setPassword(passwordEncryptionService.encrypt(password));
        userRepository.add(user);
    }

    @Override
    public void addUser(String login, String fullName, String email) {
        User user = new User(login, fullName, email, true /*always enabled*/);
        user.setId(identificationService.getUniqueId());
        userRepository.add(user);
    }

    @Override
    public void enableUser(String login, Boolean enablement) {
        User user = userRepository.queryByLogin(login);
        AssertionConcern.assertArgumentNotNull(user, 
                MessageFormat.format("Usuario {0} no encontrado",login));
    }

    @Override
    public void addGroup(String name, String description) {
        Group group = new Group(identificationService.getUniqueId(), 
                name, description);
        groupRepository.add(group);
    }
}
