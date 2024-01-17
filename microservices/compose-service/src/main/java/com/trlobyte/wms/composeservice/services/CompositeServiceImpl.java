package com.trlobyte.wms.composeservice.services;

import org.kusza.api.composite.CompositeService;
import org.kusza.api.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositeServiceImpl implements CompositeService {

    private static final Logger LOG = LoggerFactory.getLogger(CompositeServiceImpl.class);
    private final CompositeIntegration integration;

    public CompositeServiceImpl(CompositeIntegration integration) {
        this.integration = integration;
    }

    @Override
    public void addItemsToLocation(int locationId, int itemId) {
    }

    @Override
    public Item getItem(int itemId) {
        LOG.info("Retrieving item with id {}", itemId);
        return integration.getItem(itemId);
    }
}
