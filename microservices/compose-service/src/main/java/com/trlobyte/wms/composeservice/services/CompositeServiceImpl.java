package com.trlobyte.wms.composeservice.services;

import org.kusza.api.composite.CompositeService;
import org.kusza.api.composite.ItemAggregatedStorageData;
import org.kusza.api.core.item.Item;
import org.kusza.api.core.warehouse.ItemStorageInfo;
import org.kusza.api.core.warehouse.ItemStorageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public ItemAggregatedStorageData getItem(int itemId) {
        LOG.debug("Retrieving item with id {}", itemId);
        Item item = integration.getItem(itemId);
        List<ItemStorageInfo> itemStorageInfos = integration.getItemStorageInfo(itemId);
        int totalQty = 0;
        for (ItemStorageInfo info : itemStorageInfos) {
            totalQty = totalQty + info.getQuantity();
        }
        LOG.debug("Total quantity for {} | qty = {}", itemId, totalQty);
        ItemAggregatedStorageData dataItem = new ItemAggregatedStorageData(item.getItemId(),item.getName(), totalQty, itemStorageInfos);
        return dataItem;
    }

    @Override
    public List<ItemStorageRequest> getRequestsHistory() {
        LOG.debug("Retrieving warehouse requests history");
        return integration.getRequestHistory();
    }
}
