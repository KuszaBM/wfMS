package org.kusza.api.composite;

import org.kusza.api.core.item.Item;
import org.kusza.api.core.warehouse.ItemStorageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CompositeService {
    @PutMapping(
            value = "/ui/addItemToLocation"
    )
    public void addItemsToLocation(@RequestParam int locationId, @RequestParam int itemId);
    @GetMapping(
            value = "/ui/getItem/{itemId}",
            produces = "application/json"
    )
    ItemAggregatedStorageData getItem(@PathVariable int itemId);
    @GetMapping(
            value = "/ui/getHistoryStorageRequests",
            produces = "application/json"
    )
    List<ItemStorageRequest> getRequestsHistory();
}
