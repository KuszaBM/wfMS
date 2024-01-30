package com.trlobyte.wms.warehouseservice.repositories;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "itemStorageInfos")
public class ItemStorageInfoEntity {

    @Id
    private String id;
    @Version
    private Integer version;
    @Indexed(unique = true)
    private int itemStorageInfoId;
    private final String storagePlaceId;
    private final String itemId;
    private int quantity;


    public ItemStorageInfoEntity(int itemStorageInfoId, String storagePlaceId, String itemId, int quantity) {
        this.itemStorageInfoId = itemStorageInfoId;
        this.storagePlaceId = storagePlaceId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getItemStorageInfoId() {
        return itemStorageInfoId;
    }

    public String getStoragePlaceId() {
        return storagePlaceId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
