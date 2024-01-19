package com.trlobyte.wms.composeservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.kusza.api.core.item.Item;
import org.kusza.api.core.item.ItemService;
import org.kusza.api.core.storage.StoragePlace;
import org.kusza.api.core.storage.StorageService;
import org.kusza.api.core.warehouse.ItemStorageInfo;
import org.kusza.api.core.warehouse.ItemStorageRequest;
import org.kusza.api.core.warehouse.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompositeIntegration implements ItemService, StorageService, WarehouseService {

    private static final Logger LOG = LoggerFactory.getLogger(CompositeIntegration.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private String itemServiceUrl;
    private String storageServiceUrl;
    private String warehouseServiceUrl;

    @Autowired
    public CompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            @Value("${app.item-service.host}") String itemServiceHost,
            @Value("${app.storage-service.host}") String storageServiceHost,
            @Value("${app.warehouse-service.host}") String warehouseServiceHost,
            @Value("${app.item-service.port}") int itemServicePort,
            @Value("${app.warehouse-service.port}") int warehouseServicePort,
            @Value("${app.storage-service.port}") int storageServicePort) {

        this.restTemplate = restTemplate;
        this.mapper = mapper;

        itemServiceUrl = "http://" + itemServiceHost + ":" + itemServicePort + "/item/";
        storageServiceUrl = "http://" + storageServiceHost + ":" + storageServicePort + "/storage/";
        warehouseServiceUrl = "http://" + warehouseServiceHost + ":" + warehouseServicePort + "/warehouse/";
    }

    @Override
    public Item getItem(int itemId) {
        String requestUrl = itemServiceUrl + itemId;
        LOG.debug("Calling getItem APU on URL: {}", requestUrl);

        Item foundItem = restTemplate.getForObject(requestUrl, Item.class);
        if(foundItem == null) {
            LOG.debug("No item with id: {}", itemId);
            return null;
        }
        LOG.debug("found item with id: {}", itemId);
        return foundItem;
    }

    @Override
    public void createItem(Item item) {

    }

    @Override
    public void updateItemQuantityInLocation(ItemStorageRequest request) {

    }

    @Override
    public List<ItemStorageInfo> getItemStorageInfo(int itemId) {
        return null;
    }

    @Override
    public List<ItemStorageRequest> getRequestHistory() {
        try {
            String url = warehouseServiceUrl + "getRequestHistory";
            LOG.debug("Will call getRecommendations API on URL: {}", url);
            List<ItemStorageRequest> history = restTemplate
                    .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ItemStorageRequest>>() {})
                    .getBody();
            LOG.debug("Got history of warehouse requests with {} elements", history.size());
            return history;
        } catch (Exception ex) {
            LOG.warn("exception while calling method - ", ex);
            return new ArrayList<>();
        }
    }

    @Override
    public void crateStoragePlace(StoragePlace storagePlace) {

    }

    @Override
    public void addItemToStoragePlace(int storagePlaceId, int itemId) {

    }

    @Override
    public StoragePlace getStoragePlace(int storageId) {
        return null;
    }
}
