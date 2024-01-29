package com.trlobyte.wms.warehouseservice.repositories;

import org.kusza.api.core.warehouse.ItemStorageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ItemStorageRequestRepository extends CrudRepository<ItemStorageRequestEntity, String> {
    List<ItemStorageRequestEntity> findByItemId(String itemId);
    List<ItemStorageRequestEntity> findByStoragePlaceId(String storagePlaceId);
}
