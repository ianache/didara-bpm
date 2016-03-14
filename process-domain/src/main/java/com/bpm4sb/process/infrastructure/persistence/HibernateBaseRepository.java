package com.bpm4sb.process.infrastructure.persistence;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ianache
 */
@Transactional
public class HibernateBaseRepository {
    @Autowired private HibernateTransactionManager txManager;
    
    protected Session session() {
        return txManager.getSessionFactory().getCurrentSession();
    }
}
