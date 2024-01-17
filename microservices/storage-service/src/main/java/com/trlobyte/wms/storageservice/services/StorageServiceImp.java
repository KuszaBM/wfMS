package com.trlobyte.wms.storageservice.services;

import com.trlobyte.wms.storageservice.repositories.InMemoryStorageRepo;
import org.kusza.api.core.storage.StoragePlace;
import org.kusza.api.core.storage.StorageService;
import org.kusza.api.core.warehouse.ItemStorageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageServiceImp implements StorageService {

    private final InMemoryStorageRepo inMemoryStorageRepo;

    @Autowired
    public StorageServiceImp(InMemoryStorageRepo inMemoryStorageRepo) {
        this.inMemoryStorageRepo = inMemoryStorageRepo;
    }

    @Override
    public ItemStorageInfo getItemStorageInfo(int itemId) {
        return null;
    }

    @Override
    public void crateStoragePlace(StoragePlace storagePlace) {
        inMemoryStorageRepo.addStoragePlace(storagePlace);
    }

    @Override
    public void addItemToStoragePlace(int storagePlaceId, int itemId) {
        StoragePlace sp  = inMemoryStorageRepo.getStoragePlace(storagePlaceId);
        if(sp != null) {
            sp.assignItemToLocation(itemId);
        }
    }
    @Override
    public StoragePlace getStoragePlace(int storageId) {
        return inMemoryStorageRepo.getStoragePlace(storageId);
    }
}
