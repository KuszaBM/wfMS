package org.kusza.api.composite;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CompositeService {
    @PutMapping(
            value = "/ui/addItemToLocation"
    )
    public void addItemsToLocation(@RequestParam int locationId, @RequestParam int itemId);
}
