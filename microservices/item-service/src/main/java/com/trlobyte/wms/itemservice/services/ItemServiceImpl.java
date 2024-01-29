package com.trlobyte.wms.itemservice.services;

import com.trlobyte.wms.itemservice.repositories.InMemoryItemRepo;
import org.kusza.api.core.item.Item;
import org.kusza.api.core.item.ItemService;
import org.kusza.api.exceptions.InvalidInputException;
import org.kusza.api.exceptions.NotFoundException;
import org.kusza.util.http.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemServiceImpl implements ItemService {

    Logger LOG = LoggerFactory.getLogger("ItemService");
    private final ServiceUtil serviceUtil;
    private final InMemoryItemRepo inMemoryItemRepo;

    @Autowired
    public ItemServiceImpl(ServiceUtil serviceUtil, InMemoryItemRepo inMemoryItemRepo) {
        this.inMemoryItemRepo = inMemoryItemRepo;
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Item getItem(String itemId) {
        return null;
    }

    @Override
    public void createItem(Item item) {
        try {
            inMemoryItemRepo.addItem(item);
        } catch (Exception e) {
            LOG.info("error - ", e);
        }
    }
}
