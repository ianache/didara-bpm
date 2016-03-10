package com.bpm4sb.common.domain.model;

import java.util.Date;

/**
 *
 * @author ianache
 */
public interface DomainEvent {
    int eventVersion();
    Date occuredOn();
}
