package com.trlobyte.wms.warehouseservice.services;

import com.trlobyte.wms.warehouseservice.repositories.ItemStorageRequestEntity;
import org.kusza.api.core.warehouse.ItemStorageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ItemStorageRequestMapper {
    @Mappings({})
    ItemStorageRequest entityToApi(ItemStorageRequestEntity entity);
    @Mappings({
            @Mapping(target = "id", ignore = true), @Mapping(target = "version", ignore = true)
    })
    ItemStorageRequestEntity apiToEntity(ItemStorageRequest api);
}
