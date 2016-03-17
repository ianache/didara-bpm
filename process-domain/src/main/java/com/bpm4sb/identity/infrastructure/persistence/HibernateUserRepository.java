package com.bpm4sb.identity.infrastructure.persistence;

import com.bpm4sb.identity.domain.model.User;
import com.bpm4sb.identity.domain.model.UserRepository;
import com.bpm4sb.process.infrastructure.persistence.HibernateBaseRepository;
import java.util.Collection;
import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author ianache
 */
public class HibernateUserRepository extends HibernateBaseRepository implements UserRepository {

    @Override
    public void add(User user) {
        try {
            session().saveOrUpdate(user);
        } catch(ConstraintViolationException e) {
            throw new IllegalStateException("El usuario no es único");            
        }
    }

    @Override
    public void remove(User user) {
        session().delete(user);
    }

    @Override
    public Collection<User> queryByName(String name) {
        Query q = session().createQuery("from User u where u.fullName like :_name");
        q.setParameter("_name", name);
        return q.list();
    }    

    @Override
    public User queryByLogin(String login) {
        Query q = session().createQuery("from User u where u.login = :_login");
        q.setParameter("_login", login);        
        return (User) q.uniqueResult();
    }
}
