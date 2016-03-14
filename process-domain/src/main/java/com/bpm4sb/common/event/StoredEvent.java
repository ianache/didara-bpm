package com.bpm4sb.common.event;

import com.bpm4sb.common.domain.model.DomainEvent;
import java.util.Date;
import static com.bpm4sb.common.domain.model.AssertionConcern.*;

/**
 *
 * @author ianache
 */
public class StoredEvent {
    private long eventId;
    private String eventBody;
    private Date occurredOn;
    private String typeName;

    @SuppressWarnings(value="OverridableMethodCallDuringObjectConstruction")
    public StoredEvent() {
        super();
        this.setEventId(-1);
    }

    @SuppressWarnings(value="OverridableMethodCallDuringObjectConstruction")
    public StoredEvent(String aTypeName, Date anOccurredOn, String anEventBody) {
        this();
        this.setEventBody(anEventBody);
        this.setOccurredOn(anOccurredOn);
        this.setTypeName(aTypeName);
    }

    @SuppressWarnings(value="OverridableMethodCallDuringObjectConstruction")
    public StoredEvent(String aTypeName, Date anOccurredOn, String anEventBody, long anEventId) {
        this(aTypeName, anOccurredOn, anEventBody);

        this.setEventId(anEventId);
    }

    public String eventBody() {
        return this.eventBody;
    }

    public long eventId() {
        return this.eventId;
    }

    public Date occurredOn() {
        return this.occurredOn;
    }

    @SuppressWarnings("unchecked")
    public <T extends DomainEvent> T toDomainEvent() {
        Class<T> domainEventClass = null;

        try {
            domainEventClass = (Class<T>) Class.forName(this.typeName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(
                    "Class load error, because: "
                    + e.getMessage());
        }

        T domainEvent =
            EventSerializer
                .instance()
                .deserialize(this.eventBody(), domainEventClass);

        return domainEvent;
    }

    public String typeName() {
        return this.typeName;
    }

    @Override
    public boolean equals(Object toObject) {
        boolean equalObjects = false;

        if (toObject != null && this.getClass() == toObject.getClass()) {
            StoredEvent typedObject = (StoredEvent) toObject;
            equalObjects = this.eventId() == typedObject.eventId();
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
            + (1237 * 233)
            + (int) this.eventId();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "StoredEvent [eventBody=" + eventBody + ", eventId=" + eventId + ", occurredOn=" + occurredOn + ", typeName="
                + typeName + "]";
    }

    protected void setEventBody(String eventBody) {
        assertArgumentNotEmpty(eventBody, "Cuerpo del evento es requerido");
        //assertArgumentLength(anEventBody, 1, 65000, "The event body must be 65000 characters or less.");
        this.eventBody = eventBody;
    }

    protected void setEventId(long eventId) {
        this.eventId = eventId;
    }

    protected void setOccurredOn(Date occurredOn) {
        this.occurredOn = occurredOn;
    }

    protected void setTypeName(String typeName) {
        assertArgumentNotEmpty(typeName, "Se requiere nombre para el evento");
        //assertArgumentLength(typeName, 1, 100, "The event type name must be 100 characters or less.");
        this.typeName = typeName;
    }    
}
