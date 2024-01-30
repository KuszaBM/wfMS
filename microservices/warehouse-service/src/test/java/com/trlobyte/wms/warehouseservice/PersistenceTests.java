package com.trlobyte.wms.warehouseservice;


import static org.junit.jupiter.api.Assertions.*;

import com.trlobyte.wms.warehouseservice.repositories.ItemStorageInfoEntity;
import com.trlobyte.wms.warehouseservice.repositories.ItemStorageInfoRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
public class PersistenceTests extends MongoDbTestBase {
    @Autowired
    private ItemStorageInfoRepository repository;
    private ItemStorageInfoEntity savedEntity;

    @BeforeEach
    void setupDb() {
        repository.deleteAll();
        ItemStorageInfoEntity entity = new ItemStorageInfoEntity("A01", "P01", 50);
        savedEntity = repository.save(entity);

        assertEqualItemStorageInfo(entity, savedEntity);

    }

    @Test
    public void testCreate() {
        ItemStorageInfoEntity newEntity = new ItemStorageInfoEntity("A01", "P02", 60);
        repository.save(newEntity);

        ItemStorageInfoEntity foundEntity = repository.findByStoragePlaceId("A01")
                .stream()
                .filter((item) -> newEntity.getItemId().equals(item.getItemId()))
                .toList().get(0);
        assertEqualItemStorageInfo(newEntity, foundEntity);
        assertEquals(2, repository.count());
    }
    private void assertEqualItemStorageInfo(ItemStorageInfoEntity expectedEntity, ItemStorageInfoEntity actualEntity) {
        Assertions.assertEquals(expectedEntity.getId() ,actualEntity.getId());
        Assertions.assertEquals(expectedEntity.getVersion(), actualEntity.getVersion());
        Assertions.assertEquals(expectedEntity.getStoragePlaceId(), actualEntity.getStoragePlaceId());
        Assertions.assertEquals(expectedEntity.getItemId(), actualEntity.getItemId());
    }
}
