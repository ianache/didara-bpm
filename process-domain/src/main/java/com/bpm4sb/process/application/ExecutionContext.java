package com.bpm4sb.process.application;

import java.io.Serializable;

/**
 *
 * @author ianache
 */
public class ExecutionContext implements Serializable {
    private String userName;

    public ExecutionContext() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
