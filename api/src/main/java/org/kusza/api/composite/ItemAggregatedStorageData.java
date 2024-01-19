package org.kusza.api.composite;

import org.kusza.api.core.warehouse.ItemStorageInfo;

import java.util.List;

public class ItemAggregatedStorageData {
    private final int itemId;
    private final String itemName;
    private final int itemQuantity;
    private final List<ItemStorageInfo> itemStorageInfos;

    public ItemAggregatedStorageData(int itemId, String itemName, int itemQuantity, List<ItemStorageInfo> itemStorageInfos) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemStorageInfos = itemStorageInfos;
    }
    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public List<ItemStorageInfo> getItemStorageInfos() {
        return itemStorageInfos;
    }
}
