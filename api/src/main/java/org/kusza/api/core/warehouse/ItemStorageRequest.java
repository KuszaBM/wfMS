package org.kusza.api.core.warehouse;

import java.sql.Timestamp;

public class ItemStorageRequest {
    private final int operationId;
    private final int itemId;
    private final int fromLocationId;
    private final int itemQty;
    private final int toLocationId;
    private final Timestamp requestedTs;
    private Timestamp acceptedTs = null;

    public ItemStorageRequest(int operationId, int itemId, int fromLocationId, int itemQty, int storagePlaceId, Timestamp requestedTs) {
        this.operationId = operationId;
        this.itemId = itemId;
        this.fromLocationId = fromLocationId;
        this.itemQty = itemQty;
        this.toLocationId = storagePlaceId;
        this.requestedTs = requestedTs;
    }

    public int getOperationId() {
        return operationId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getItemQty() {
        return itemQty;
    }

    public int getStoragePlaceId() {
        return toLocationId;
    }

    public int getFromLocationId() {
        return fromLocationId;
    }

    public int getToLocationId() {
        return toLocationId;
    }

    public Timestamp getRequestedTs() {
        return requestedTs;
    }

    public Timestamp getAcceptedTs() {
        return acceptedTs;
    }

    public void setAcceptedTs(Timestamp acceptedTs) {
        this.acceptedTs = acceptedTs;
    }
}
