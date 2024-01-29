package org.kusza.api.core.warehouse;

import java.sql.Timestamp;

public class ItemStorageRequest {
    private final int operationId;
    private final String itemId;
    private final String fromLocationId;
    private final int itemQty;
    private final String storagePlaceId;
    private final Timestamp requestedTs;
    private Timestamp acceptedTs;

    public ItemStorageRequest(int operationId, String itemId, String fromLocationId, int itemQty, String storagePlaceId, Timestamp requestedTs) {
        this.operationId = operationId;
        this.itemId = itemId;
        this.fromLocationId = fromLocationId;
        this.itemQty = itemQty;
        this.storagePlaceId = storagePlaceId;
        this.requestedTs = requestedTs;
        this.acceptedTs = null;
    }

    public ItemStorageRequest() {
        this.operationId = 0;
        this.itemId = "";
        this.fromLocationId = "";
        this.itemQty = 0;
        this.storagePlaceId = "";
        this.requestedTs = null;
        this.acceptedTs = null;
    }

    public int getOperationId() {
        return operationId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getItemQty() {
        return itemQty;
    }

    public String getStoragePlaceId() {
        return storagePlaceId;
    }

    public String getFromLocationId() {
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
