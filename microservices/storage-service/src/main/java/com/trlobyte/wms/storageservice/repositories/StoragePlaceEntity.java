package com.trlobyte.wms.storageservice.repositories;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import java.util.Set;

@Entity
public class StoragePlaceEntity {
    @Id
    @GeneratedValue
    private int id;
    @Version
    private int version;
    private final String storagePlaceId;
    private String storagePlaceName;
    private final String storageId;
    private Set<Integer> itemsInLocation;

    public StoragePlaceEntity(String storagePlaceId, String storageId) {
        this.storagePlaceId = storagePlaceId;
        this.storageId = storageId;
    }

    public StoragePlaceEntity(String storagePlaceId, String storagePlaceName, String storageId, Set<Integer> itemsInLocation) {
        this.storagePlaceId = storagePlaceId;
        this.storagePlaceName = storagePlaceName;
        this.storageId = storageId;
        this.itemsInLocation = itemsInLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getStoragePlaceId() {
        return storagePlaceId;
    }

    public String getStoragePlaceName() {
        return storagePlaceName;
    }

    public void setStoragePlaceName(String storagePlaceName) {
        this.storagePlaceName = storagePlaceName;
    }

    public String getStorageId() {
        return storageId;
    }

    public Set<Integer> getItemsInLocation() {
        return itemsInLocation;
    }

    public void setItemsInLocation(Set<Integer> itemsInLocation) {
        this.itemsInLocation = itemsInLocation;
    }
}
