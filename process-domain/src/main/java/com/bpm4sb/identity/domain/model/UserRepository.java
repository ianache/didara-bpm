package com.bpm4sb.identity.domain.model;

import java.util.Collection;

/**
 *
 * @author ianache
 */
public interface UserRepository {
    void add(User user);
    void remove(User user);
    Collection<User> queryByName(String name);
    public User queryByLogin(String login);
}
