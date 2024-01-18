package org.kusza.api.core.warehouse;

public class ItemStorageInfo {
    private final int itemStorageInfoId;
    private final int storagePlaceId;
    private final int itemId;
    private int quantity;

    public ItemStorageInfo(int itemStorageInfoId, int storagePlaceId, int itemId) {
        this.itemStorageInfoId = itemStorageInfoId;
        this.storagePlaceId = storagePlaceId;
        this.itemId = itemId;
        this.quantity = 0;
    }

    public int getStoragePlaceId() {
        return storagePlaceId;
    }

    public void updateItemQuantity(int qty) {
        this.quantity = this.quantity + qty;
    }
    public int getItemStorageInfoId() {
        return itemStorageInfoId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}
