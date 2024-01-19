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
        try {
            addItem(new Item(13, "cp1", 1000, 9.2));
            addItem(new Item(14, "cp2", 1100, 14.0));
            addItem(new Item(10, "item-1", 1100, 1.0));
            addItem(new Item(11, "item-2", 1200, 10.0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
