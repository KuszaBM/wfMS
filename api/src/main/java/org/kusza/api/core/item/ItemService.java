package org.kusza.api.core.item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ItemService {
    @GetMapping(
            value = "/item/{itemId}",
            produces = "application/json")
    Item getItem(@PathVariable int itemId);

    @PostMapping(
            value = "/item/add",
            consumes = "application/json")
    void createItem(@RequestBody Item item);

}
