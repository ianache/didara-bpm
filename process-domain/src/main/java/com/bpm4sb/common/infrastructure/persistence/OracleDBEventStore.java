package com.bpm4sb.common.infrastructure.persistence;

import com.bpm4sb.common.domain.model.DomainEvent;
import com.bpm4sb.common.event.EventSerializer;
import com.bpm4sb.common.event.EventStore;
import com.bpm4sb.common.event.StoredEvent;
import com.bpm4sb.process.domain.model.IdentificationService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

/**
 *
 * @author ianache
 */
public class OracleDBEventStore implements EventStore {
    @Autowired private HibernateTransactionManager txManager;
    
    @Override
    public List<StoredEvent> allStoredEventsBetween(Date fromDate, Date thruDate) {
        Query q = getSession().createQuery("select se from StoredEvent se where se.occurredOn between :_fromDate and :_thruDate");
        q.setParameter("_fromDate", fromDate);
        q.setParameter("_thruDate", thruDate);
        return q.list();
    }

    @Override
    public List<StoredEvent> allStoredEventsSince(long storedEventId) {
        Query q = getSession().createQuery("select se from StoredEvent se where se.id >= :_storedEventId");
        q.setParameter("_storedEventId", storedEventId);
        return q.list();
    }

    @Override
    public StoredEvent append(DomainEvent domainEvent) {
        StoredEvent storedEvent = 
           new StoredEvent(domainEvent.getClass().getSimpleName(), 
                   Calendar.getInstance().getTime(), 
                   EventSerializer.instance().serialize(domainEvent));
        getSession().persist(storedEvent);
        return storedEvent;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long countStoredEvents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Session getSession() {
        return txManager.getSessionFactory().getCurrentSession();
    }    

    @Override
    public List<StoredEvent> allStoredEventsBetween(long fromEventId, long thruEventId) {
        Query q = getSession().createQuery("select se from StoredEvent se where se.occurredOn between :_fromDate and :_thruDate");
        q.setParameter("_fromDate", fromEventId);
        q.setParameter("_thruDate", thruEventId);
        return q.list();
    }
}
