package com.trlobyte.wms.warehouseservice.repositories;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "itemStorageInfos")
@CompoundIndexes({
        @CompoundIndex(name = "unique_pair", def = "{'storagePlaceId' : 1, 'itemId' : 1}", unique = true)
})
public class ItemStorageInfoEntity {
    @Id
    private String id;
    @Version
    private Integer version;
    private final String storagePlaceId;
    private final String itemId;
    private int quantity;


    public ItemStorageInfoEntity(String storagePlaceId, String itemId, int quantity) {
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
