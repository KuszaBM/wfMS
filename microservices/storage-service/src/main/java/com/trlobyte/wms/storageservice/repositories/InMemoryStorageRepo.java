package com.trlobyte.wms.storageservice.repositories;

import org.kusza.api.core.storage.StoragePlace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryStorageRepo {
    Logger LOG = LoggerFactory.getLogger("StorageRepo");
    private Map<String, StoragePlace> storagePlaces;
    public StoragePlace getStoragePlace(int storagePlaceId) {
        return storagePlaces.get(storagePlaceId);
    }
    public InMemoryStorageRepo() {
        this.storagePlaces = new HashMap<>();
        addStoragePlace(new StoragePlace("A01-1", "WAR01", "A01"));
        addStoragePlace(new StoragePlace("A02-1", "WAR01", "A02"));
        addStoragePlace(new StoragePlace("B01-1", "WAR01", "B01"));
    }
    public void addStoragePlace(StoragePlace storagePlace) {
        if(storagePlaces.get(storagePlace.getStoragePlaceId()) == null) {
            storagePlaces.put(storagePlace.getStoragePlaceId(), storagePlace);
            LOG.info("Added storagePlace Name: {} | Id: {} ", storagePlace.getStoragePlaceName(), storagePlace.getStorageId());
            return;
        }
        LOG.info("StoragePlace cant be added - already in maps");
    }
}
