package com.bpm4sb.common.domain.model;

/**
 *
 * @author ianache
 * @param <T>
 */
public interface DomainEventSubscriber<T> {
    public void handleEvent(final T domainEvent);
    public Class<T> subscribedToEventType();    
}
