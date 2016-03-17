package com.bpm4sb.identity.domain.model;

/**
 *
 * @author ianache
 */
public interface MembershipService {
    /**
     * 
     * @param group
     * @param user
     * @return 
     */
    Boolean queryUserInNestedGroup(Group group, User user);
}
