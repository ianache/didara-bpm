package com.bpm4sb.identity.infrastructure.persistence;

import com.bpm4sb.identity.domain.model.Group;
import com.bpm4sb.identity.domain.model.GroupRepository;
import com.bpm4sb.process.infrastructure.persistence.HibernateBaseRepository;
import java.util.Collection;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author ianache
 */
public class HibernateGroupRepository extends HibernateBaseRepository implements GroupRepository {

    @Override
    public void add(Group group) {
        try {
            session().saveOrUpdate(group);
        } catch(ConstraintViolationException e) {
            throw new IllegalStateException("El grupo no es único");
        }
    }

    @Override
    public void remove(Group group) {
        session().delete(group);
    }

    @Override
    public Collection<Group> queryGroups() {
        return session().createQuery("from Group as g where g.parentGroup = null").list();        
    }    
}
