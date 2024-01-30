package org.kusza.api.core.warehouse;

public class ItemStorageInfo {
    private final int itemStorageInfoId;
    private final String storagePlaceId;
    private final String itemId;
    private int quantity = 0;

    public  ItemStorageInfo() {
        this.itemStorageInfoId = 0;
        this.storagePlaceId = "N/E";
        this.itemId = "";
    }

    public ItemStorageInfo(int itemStorageInfoId, String storagePlaceId, String itemId) {
        this.itemStorageInfoId = itemStorageInfoId;
        this.storagePlaceId = storagePlaceId;
        this.itemId = itemId;
        this.quantity = 0;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStoragePlaceId() {
        return storagePlaceId;
    }

    public void updateItemQuantity(int qty) {
        this.quantity = this.quantity + qty;
    }
    public int getItemStorageInfoId() {
        return itemStorageInfoId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}
