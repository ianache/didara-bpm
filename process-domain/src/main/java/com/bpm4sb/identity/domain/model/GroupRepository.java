package com.bpm4sb.identity.domain.model;

import java.util.Collection;

/**
 *
 * @author USUARIO
 */
public interface GroupRepository {
    void add(Group group);
    void remove(Group group);
    Collection<Group> queryGroups();
}
