package com.bpm4sb.common.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vaughn Vernon
 * @author ianache (enhancement)
 */
public class DomainEventPublisher {
    private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
        @Override
        protected DomainEventPublisher initialValue() {
            return new DomainEventPublisher();
        }
    };
    
    @SuppressWarnings("rawtypes")
    private List subscribers;
    private boolean publishing;

    public boolean isPublishing() {
        return publishing;
    }

    public void setPublishing(boolean publishing) {
        this.publishing = publishing;
    }
    
    public static DomainEventPublisher instance() {
        return instance.get();
    }

    public <T> void publish(final T aDomainEvent) {
        if (!this.isPublishing() && this.hasSubscribers()) {
            try {
                this.setPublishing(true);
                Class<?> eventType = aDomainEvent.getClass();

                @SuppressWarnings("unchecked")
                List<DomainEventSubscriber<T>> allSubscribers = this.subscribers();
                
                allSubscribers.stream().forEach((subscriber) -> {
                    Class<?> subscribedToType = subscriber.subscribedToEventType();
                    if (eventType == subscribedToType || subscribedToType == DomainEvent.class) {
                        subscriber.handleEvent(aDomainEvent);
                    }
                });

            } finally {
                this.setPublishing(false);
            }
        }        
    }
    
    private boolean hasSubscribers() {
        return this.subscribers != null;
    }

    public List getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List subscribers) {
        this.subscribers = subscribers;
    }
    
    private DomainEventPublisher() {
        super();
        this.setPublishing(false);
        this.ensureSubscribersList();
    }
    
    @SuppressWarnings("rawtypes")
    private void ensureSubscribersList() {
        if (!this.hasSubscribers()) {
            this.setSubscribers(new ArrayList());
        }
    }   

    @SuppressWarnings("rawtypes")
    private List subscribers() {
        return this.subscribers;
    }
}
