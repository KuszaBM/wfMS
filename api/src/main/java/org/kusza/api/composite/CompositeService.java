package org.kusza.api.composite;

import org.kusza.api.core.item.Item;
import org.kusza.api.core.warehouse.ItemStorageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CompositeService {
    @PostMapping(
            value = "/ui/addItemToLocation"
    )
    public void addItemsToLocation(@RequestParam String locationId, @RequestParam String itemId);
    @GetMapping(
            value = "/ui/getItem/{itemId}",
            produces = "application/json"
    )
    ItemAggregatedStorageData getItem(@PathVariable String itemId);
    @PostMapping(
            value = "/ui/warehouseMoveOrder",
            consumes = "application/json"
    )
    ResponseMoveOrder warehouseMoveOrder(@RequestBody ItemStorageRequest request);
    @GetMapping(
            value = "/ui/getHistoryStorageRequests",
            produces = "application/json"
    )
    List<ItemStorageRequest> getRequestsHistory();
}
