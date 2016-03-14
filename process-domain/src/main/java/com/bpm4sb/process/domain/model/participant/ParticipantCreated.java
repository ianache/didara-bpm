package com.bpm4sb.process.domain.model.participant;

import com.bpm4sb.common.domain.model.DomainEvent;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ianache
 */
public class ParticipantCreated implements DomainEvent {
    private String name;
    private int eventVersion;
    private String participantId;
    private Date occurredOn;

    public ParticipantCreated(String name, String participantId) {
        this.name = name;
        this.participantId = participantId;
        this.setOccurredOn(Calendar.getInstance().getTime());
        this.eventVersion = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public Date getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(Date occurredOn) {
        this.occurredOn = occurredOn;
    }

    
    
    @Override
    public int eventVersion() {
        return this.eventVersion;
    }

    @Override
    public Date occuredOn() {
        return this.occurredOn;
    }    
}
