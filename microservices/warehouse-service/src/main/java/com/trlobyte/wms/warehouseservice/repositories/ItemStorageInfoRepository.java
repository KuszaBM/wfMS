package com.trlobyte.wms.warehouseservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ItemStorageInfoRepository extends CrudRepository<ItemStorageInfoEntity, String> {
    List<ItemStorageInfoEntity> findByItemId(String itemId);
    List<ItemStorageInfoEntity> findByStoragePlaceId(String storagePlaceId);

}
