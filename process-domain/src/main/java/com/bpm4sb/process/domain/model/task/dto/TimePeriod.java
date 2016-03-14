package com.bpm4sb.process.domain.model.task.dto;

import java.util.Date;

/**
 *
 * @author ianache
 */
public class TimePeriod {
    private Date fromDate;
    private Date thruDate;

    public TimePeriod() {
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getThruDate() {
        return thruDate;
    }

    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }
}
