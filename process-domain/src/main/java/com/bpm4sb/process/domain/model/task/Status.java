package com.bpm4sb.process.domain.model.task;

/**
 *
 * @author USUARIO
 */
public enum Status {
    Created(1),
    Ready(2),
    Reserved(3),
    InProgress(4),
    Suspended(5),
    Completed(6),
    Failed(7),
    Error(8),
    Exited(9),
    Obsolete(10);

    private final int value;
    Status(int value) {
        this.value = value;
    }
    
    public int value() {
        return this.value;
    }
}
