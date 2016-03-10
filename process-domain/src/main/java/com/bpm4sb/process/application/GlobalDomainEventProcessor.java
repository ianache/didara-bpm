package com.bpm4sb.process.application;

import com.bpm4sb.common.domain.model.DomainEvent;
import com.bpm4sb.common.domain.model.DomainEventPublisher;
import com.bpm4sb.common.domain.model.DomainEventSubscriber;
import com.bpm4sb.common.event.EventStore;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ianache
 */
@Aspect
public class GlobalDomainEventProcessor {
    @Autowired EventStore eventStore;

    public GlobalDomainEventProcessor() {
        super();
    }        
    
    public static void register() {
        (new GlobalDomainEventProcessor()).listen();
    }

    @Before("execution(* com.bpm4sb.process.application.*.*(..))")
    private void listen() {
        DomainEventPublisher.instance()
                .publish(new DomainEventSubscriber<DomainEvent>() {

            @Override
            public void handleEvent(DomainEvent domainEvent) {
                store(domainEvent);
            }

            @Override
            public Class<DomainEvent> subscribedToEventType() {
                return DomainEvent.class;
            }
        });
    }
    
    private void store(DomainEvent domainEvent) {
        this.eventStore.append(domainEvent);
    }
}
