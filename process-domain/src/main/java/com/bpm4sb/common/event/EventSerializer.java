package com.bpm4sb.common.event;

import com.bpm4sb.common.domain.model.DomainEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author ianache
 */
public class EventSerializer {
    private Gson gson;
    
    private static EventSerializer uniqueInstance;

    public static synchronized EventSerializer instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new EventSerializer();
        }

        return uniqueInstance;
    }

    public String serialize(DomainEvent domainEvent) {
        return this.gson().toJson(domainEvent);
    }

    public <T extends DomainEvent> T deserialize(String serialized, final Class<T> toType) {
        return this.gson().fromJson(serialized, toType);
    }

    private EventSerializer() {
    }

    private Gson gson() {
        if(gson == null) {
            this.gson = new GsonBuilder().create();
        }
        return gson;
    }
}
