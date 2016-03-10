package com.bpm4sb.common.event;

import com.bpm4sb.common.domain.model.DomainEvent;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ianache
 */
public interface EventStore {
    /**
     * 
     * @param fromDate
     * @param thruDate
     * @return 
     */
    public List<StoredEvent> allStoredEventsBetween(Date fromDate, Date thruDate);
    /**
     * 
     * @param fromEventId
     * @param thruEventId
     * @return 
     */
    public List<StoredEvent> allStoredEventsBetween(long fromEventId, long thruEventId);
    /**
     * 
     * @param fromOccurredOn
     * @return 
     */
    public List<StoredEvent> allStoredEventsSince(long fromOccurredOn);
    /**
     * 
     * @param domainEvent
     * @return 
     */
    public StoredEvent append(DomainEvent domainEvent);
    /**
     * 
     */
    public void close();
    /**
     * 
     * @return 
     */
    public long countStoredEvents();    
}
