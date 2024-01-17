package org.kusza.api.core.storage;

import org.kusza.api.core.warehouse.ItemStorageInfo;
import org.springframework.web.bind.annotation.*;

public interface StorageService {
    @GetMapping(
            value = "/storage/info/{itemId}",
            produces = "application/json"
    )
    ItemStorageInfo getItemStorageInfo(@PathVariable int itemId);
    @PostMapping(
            value = "/storage/addStoragePlace",
            consumes = "application/json"
    )
    void crateStoragePlace(@RequestBody StoragePlace storagePlace);
    @PutMapping(
            value = "/storage/addItemToLocation"
    )
    void addItemToStoragePlace(@RequestParam int storagePlaceId, @RequestParam int itemId);
    @GetMapping(
            value = "/storage/{storageId}",
            produces = "application/json"
    )
    StoragePlace getStoragePlace(@PathVariable int storageId);

}
