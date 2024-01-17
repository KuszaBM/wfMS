package org.kusza.api.core.warehouse;

public class ItemStorageRequest {
    private final int operationId;
    private final int itemId;
    private final int fromLocationId;
    private final int itemQty;
    private final int toLocationId;

    public ItemStorageRequest(int operationId, int itemId, int fromLocationId, int itemQty, int storagePlaceId) {
        this.operationId = operationId;
        this.itemId = itemId;
        this.fromLocationId = fromLocationId;
        this.itemQty = itemQty;
        this.toLocationId = storagePlaceId;
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
}
