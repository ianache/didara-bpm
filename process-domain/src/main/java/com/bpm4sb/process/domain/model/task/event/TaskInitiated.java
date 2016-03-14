package com.bpm4sb.process.domain.model.task.event;

import com.bpm4sb.common.domain.model.DomainEvent;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ianache
 */
public class TaskInitiated implements DomainEvent {
    private final int version;
    private final Date occuredOn;

    public TaskInitiated() {
        this.version = 1;
        this.occuredOn = Calendar.getInstance().getTime();
    }
    
    @Override
    public int eventVersion() {
        return this.version;
    }

    @Override
    public Date occuredOn() {
        return this.occuredOn;
    }
    
    
}
