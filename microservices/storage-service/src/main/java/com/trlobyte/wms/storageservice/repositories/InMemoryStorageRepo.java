package com.trlobyte.wms.storageservice.repositories;

import org.kusza.api.core.storage.StoragePlace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InMemoryStorageRepo {
    Logger LOG = LoggerFactory.getLogger("StorageRepo");
    private Map<Integer, StoragePlace> storagePlaces;

    public StoragePlace getStoragePlace(int storagePlaceId) {
        return storagePlaces.get(storagePlaceId);
    }
    public InMemoryStorageRepo() {
        this.storagePlaces = new HashMap<>();
    }
    public void addStoragePlace(StoragePlace storagePlace) {
        if(storagePlaces.get(storagePlace.getStorageId()) == null) {
            storagePlaces.put(storagePlace.getStorageId(), storagePlace);
            LOG.info("Added storagePlace Name: {} | Id: {} ", storagePlace.getStoragePlaceName(), storagePlace.getStorageId());
            return;
        }
        LOG.info("StoragePlace cant be added - already in maps");
    }
}
