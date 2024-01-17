package org.kusza.api.composite;

import org.kusza.api.core.item.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CompositeService {
    @PutMapping(
            value = "/ui/addItemToLocation"
    )
    public void addItemsToLocation(@RequestParam int locationId, @RequestParam int itemId);
    @GetMapping(
            value = "ui/getProduct/{itemId}",
            produces = "application/json"
    )
    Item getItem(@PathVariable int itemId);
}
