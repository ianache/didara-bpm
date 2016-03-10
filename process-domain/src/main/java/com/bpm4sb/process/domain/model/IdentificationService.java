package com.bpm4sb.process.domain.model;

import java.util.UUID;

/**
 *
 * @author ianache
 */
public class IdentificationService {
    public String getUniqueId() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}
