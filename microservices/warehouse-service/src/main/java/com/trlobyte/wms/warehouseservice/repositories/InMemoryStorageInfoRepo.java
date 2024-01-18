package com.trlobyte.wms.warehouseservice.repositories;

import org.kusza.api.core.warehouse.ItemStorageInfo;
import org.kusza.api.core.warehouse.ItemStorageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryStorageInfoRepo {
    private final Logger LOG = LoggerFactory.getLogger(InMemoryStorageInfoRepo.class);
    List<ItemStorageInfo> storedItems;
    List<ItemStorageRequest> requestHistory;

    public InMemoryStorageInfoRepo() {
        this.storedItems = new ArrayList<>();
        this.requestHistory = new ArrayList<>();


        storedItems.add(new ItemStorageInfo(1, 1, 10));
        storedItems.add(new ItemStorageInfo(2, 1, 11));
        storedItems.add(new ItemStorageInfo(1, 2, 10));

        ItemStorageRequest req = new ItemStorageRequest(1, 10, 54, 50, 2, new Timestamp(System.currentTimeMillis()));
        updateStorage(req);
    }

    public void updateStorage(ItemStorageRequest request) {
        List<ItemStorageInfo> temp = storedItems.stream().filter(s -> {
            return s.getItemId() == request.getItemId();
        }).filter(s -> {
            return request.getStoragePlaceId() == s.getStoragePlaceId();
        }).toList();
        if(temp.size() > 1) {
            LOG.info("Not consist data in db - cannot update");
            return;
        }
        if(temp.isEmpty()) {
            ItemStorageInfo newEntry = new ItemStorageInfo(11, request.getStoragePlaceId(), request.getItemId());
            newEntry.updateItemQuantity(request.getItemQty());
            storedItems.add(newEntry);
        }
        if(temp.size() == 1)
            temp.get(0).updateItemQuantity(request.getItemQty());
        request.setAcceptedTs(new Timestamp(System.currentTimeMillis()));
        requestHistory.add(request);
    }

    public List<ItemStorageRequest> getRequestHistory() {
        return requestHistory;
    }

    public List<ItemStorageInfo> getAllForItem(int itemId) {
        List<ItemStorageInfo> foundItems = new ArrayList<>();
        for(ItemStorageInfo info : storedItems) {
            if(info.getItemId() == itemId)
                foundItems.add(info);
        }
        return foundItems;
    }
}
