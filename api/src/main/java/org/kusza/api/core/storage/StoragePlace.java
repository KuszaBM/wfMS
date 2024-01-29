package org.kusza.api.core.storage;

import java.util.HashSet;
import java.util.Set;

public class StoragePlace {
    private final String storagePlaceId;
    private String storagePlaceName;
    private final String storageId;
    private Set<Integer> itemsInLocation;
    //TODO in future add more info about storage place:
    public StoragePlace(String storagePlaceId, String storageId, String storagePlaceName) {
        this.storagePlaceName = storagePlaceName;
        this.storagePlaceId = storagePlaceId;
        this.storageId = storageId;
        itemsInLocation = new HashSet<>();
    }

    public void assignItemToLocation(int itemId) {
        itemsInLocation.add(itemId);
    }
    public void removeItemFromLocation(int itemId) {
        itemsInLocation.remove(itemId);
    }
    public void setStoragePlaceName(String storagePlaceName) {
        this.storagePlaceName = storagePlaceName;
    }
    public String getStoragePlaceId() {
        return storagePlaceId;
    }
    public String getStoragePlaceName() {
        return storagePlaceName;
    }
    public String getStorageId() {
        return storageId;
    }
}
