package com.trlobyte.wms.itemservice.repositories;

import org.kusza.api.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryItemRepo {
    Logger LOG = LoggerFactory.getLogger("ItemRepo");
    private Map<Integer, Item> items;

    public InMemoryItemRepo() {
        this.items = new HashMap<>();
    }
    public Item getItemById(int itemId) {
        return items.get(itemId);
    }
    public void addItem(Item item) throws Exception {
        if(!items.containsKey(item.getItemId())) {
            items.put(item.getItemId(), item);
            return;
        }
        throw new Exception("Item with Id = " + item.getItemId() + " already in map");
    }
}
