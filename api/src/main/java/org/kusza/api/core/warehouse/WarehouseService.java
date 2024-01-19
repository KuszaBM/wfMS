package org.kusza.api.core.warehouse;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface WarehouseService {
    @PostMapping(
            value = "/warehouse/updateItemQuantityInLocation",
            consumes = "application/json"
    )
    void updateItemQuantityInLocation(@RequestBody ItemStorageRequest request);
    @GetMapping(
            value = "/warehouse/getItemStorageInfo/{itemId}",
            produces = "application/json"
    )
    List<ItemStorageInfo> getItemStorageInfo(@PathVariable int itemId);

    @GetMapping(
            value = "/warehouse/getRequestHistory",
            produces = "application/json"
    )
    List<ItemStorageRequest> getRequestHistory();
}
