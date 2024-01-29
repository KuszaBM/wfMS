package com.trlobyte.wms.warehouseservice.services;

import com.trlobyte.wms.warehouseservice.repositories.ItemStorageInfoEntity;
import org.kusza.api.core.warehouse.ItemStorageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ItemStorageInfoMapper {
    @Mappings({})
    ItemStorageInfo entityToApi(ItemStorageInfoEntity entity);
    @Mappings({
            @Mapping(target = "id", ignore = true), @Mapping(target = "version", ignore = true)
    })
    ItemStorageInfoEntity apiToEntity(ItemStorageInfo api);
}
