package org.kusza.api.core.warehouse;

import java.sql.Timestamp;

public class ItemStorageRequest {
    private final int operationId;
    private final int itemId;
    private final int fromLocationId;
    private final int itemQty;
    private final int storagePlaceId;
    private final Timestamp requestedTs;
    private Timestamp acceptedTs = null;

    public ItemStorageRequest(int operationId, int itemId, int fromLocationId, int itemQty, int storagePlaceId, Timestamp requestedTs) {
        this.operationId = operationId;
        this.itemId = itemId;
        this.fromLocationId = fromLocationId;
        this.itemQty = itemQty;
        this.storagePlaceId = storagePlaceId;
        this.requestedTs = requestedTs;
    }

    public ItemStorageRequest() {
        this.operationId = 0;
        this.itemId = 0;
        this.fromLocationId = 0;
        this.itemQty = 0;
        this.storagePlaceId = 0;
        this.requestedTs = null;
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
        return storagePlaceId;
    }

    public int getFromLocationId() {
        return fromLocationId;
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
