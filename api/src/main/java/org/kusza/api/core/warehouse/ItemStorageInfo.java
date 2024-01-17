package org.kusza.api.core.warehouse;

public class ItemStorageInfo {
    private final int itemStorageInfoId;
    private final int itemId;
    private final int quantity;

    public ItemStorageInfo(int itemStorageInfoId, int itemId, int quantity) {
        this.itemStorageInfoId = itemStorageInfoId;
        this.itemId = itemId;
        this.quantity = quantity;
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
