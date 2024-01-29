package org.kusza.api.core.storage;

import org.kusza.api.core.warehouse.ItemStorageInfo;
import org.springframework.web.bind.annotation.*;

public interface StorageService {
    @PostMapping(
            value = "/storage/addStoragePlace",
            consumes = "application/json"
    )
    void crateStoragePlace(@RequestBody StoragePlace storagePlace);
    @PutMapping(
            value = "/storage/addItemToLocation"
    )
    void addItemToStoragePlace(@RequestParam String storagePlaceId, @RequestParam String itemId);
    @GetMapping(
            value = "/storage/{storageId}",
            produces = "application/json"
    )
    StoragePlace getStoragePlace(@PathVariable String storageId);
}
