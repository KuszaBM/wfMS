package com.trlobyte.wms.warehouseservice.services;

import com.trlobyte.wms.warehouseservice.repositories.InMemoryStorageInfoRepo;
import org.kusza.api.core.warehouse.ItemStorageInfo;
import org.kusza.api.core.warehouse.ItemStorageRequest;
import org.kusza.api.core.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WarehouseServiceImpl implements WarehouseService {
    private final InMemoryStorageInfoRepo storageInfoRepo;

    @Autowired
    public WarehouseServiceImpl(InMemoryStorageInfoRepo storageInfoRepo) {
        this.storageInfoRepo = storageInfoRepo;
    }

    @Override
    public void updateItemQuantityInLocation(ItemStorageRequest request) {
        storageInfoRepo.updateStorage(request);
    }

    @Override
    public List<ItemStorageInfo> getItemStorageInfo(int itemId) {
        return storageInfoRepo.getAllForItem(itemId);
    }

    @Override
    public List<ItemStorageRequest> getRequestHistory() {
        return storageInfoRepo.getRequestHistory();
    }
}
