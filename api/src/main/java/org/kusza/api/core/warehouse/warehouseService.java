package org.kusza.api.core.warehouse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface warehouseService {
    @PostMapping(
            value = "/storage/updateItemQuantityInLocation",
            consumes = "application/json"
    )
    void updateItemQuantityInLocation(@RequestBody ItemStorageRequest request);
}
