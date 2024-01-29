package org.kusza.api.composite;

import java.sql.Timestamp;

public class ResponseMoveOrder {
    private final boolean success;
    private final String errorMessage;
    private final Timestamp timestamp;

    public ResponseMoveOrder(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
