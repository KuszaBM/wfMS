package com.trlobyte.wms.warehouseservice.services;

import com.trlobyte.wms.warehouseservice.repositories.ItemStorageInfoEntity;
import com.trlobyte.wms.warehouseservice.repositories.ItemStorageInfoRepository;
import com.trlobyte.wms.warehouseservice.repositories.ItemStorageRequestRepository;
import org.kusza.api.composite.ResponseMoveOrder;
import org.kusza.api.core.warehouse.ItemStorageInfo;
import org.kusza.api.core.warehouse.ItemStorageRequest;
import org.kusza.api.core.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class WarehouseServiceImpl implements WarehouseService {
    private final ItemStorageInfoRepository itemStorageInfoRepository;
    private final ItemStorageRequestRepository itemStorageRequestRepository;
    private final ItemStorageInfoMapper itemStorageInfoMapper;
    private final ItemStorageRequestMapper itemStorageRequestMapper;

    @Autowired
    public WarehouseServiceImpl(ItemStorageInfoRepository storageInfoRepo, ItemStorageRequestRepository itemStorageRequestRepository, ItemStorageInfoMapper itemStorageInfoMapper, ItemStorageRequestMapper itemStorageRequestMapper) {
        this.itemStorageInfoRepository = storageInfoRepo;
        this.itemStorageRequestRepository = itemStorageRequestRepository;
        this.itemStorageInfoMapper = itemStorageInfoMapper;
        this.itemStorageRequestMapper = itemStorageRequestMapper;
    }

    @Override
    public ResponseMoveOrder updateItemQuantityInLocation(ItemStorageRequest request) {
        String responseErrorMsg = null;
        List<ItemStorageInfoEntity> fromLocationEntity = null;
        List<ItemStorageInfoEntity> toLocationEntity = null;
        if(!request.getFromLocationId().equals("INBOUND")) {
             fromLocationEntity = itemStorageInfoRepository.findByStoragePlaceId(request.getFromLocationId())
                    .stream()
                    .filter((z) -> request.getItemId().equals(z.getItemId()))
                    .toList();
            if(fromLocationEntity.isEmpty()) {
                responseErrorMsg = "There is no location" + request.getFromLocationId() + " or no item " + request.getItemId() + " stored in this location";
                return new ResponseMoveOrder(false, responseErrorMsg);
            }
            if(fromLocationEntity.size() > 1) {
                responseErrorMsg = "Fatal data error, do not move database broken";
                return new ResponseMoveOrder(false, responseErrorMsg);
            }
        }
        if(!request.getStoragePlaceId().equals("OUTBOUND")) {
            toLocationEntity = itemStorageInfoRepository.findByStoragePlaceId(request.getStoragePlaceId())
                    .stream()
                    .filter((z) -> request.getItemId().equals(z.getItemId()))
                    .toList();
            if(toLocationEntity.size() > 1) {
                responseErrorMsg = "Fatal data error, do not move database broken";
                return new ResponseMoveOrder(false, responseErrorMsg);
            }
        }
        if (fromLocationEntity != null) {
            if(fromLocationEntity.get(0).getQuantity() < request.getItemQty()) {
                return new ResponseMoveOrder(false, "not enough item {} quantity");
            }
            int fromQty = fromLocationEntity.get(0).getQuantity();
            fromLocationEntity.get(0).setQuantity(fromQty - request.getItemQty());
        }
        if(toLocationEntity != null) {
            if(toLocationEntity.isEmpty()) {
                ItemStorageInfo itemStorageInfo = new ItemStorageInfo(1, request.getStoragePlaceId(), request.getItemId());
                itemStorageInfo.setQuantity(request.getItemQty());
                ItemStorageInfoEntity e = itemStorageInfoRepository.save(itemStorageInfoMapper.apiToEntity(itemStorageInfo));
            } else {
                ItemStorageInfoEntity e = toLocationEntity.get(0);
                e.setQuantity(e.getQuantity() + request.getItemQty());
                itemStorageInfoRepository.save(e);
                itemStorageInfoRepository.save(fromLocationEntity.get(0));
            }
        }
        itemStorageRequestRepository.save(itemStorageRequestMapper.apiToEntity(request));
        return new ResponseMoveOrder(true, "");
        //itemStorageInfoRepository.updateStorage(request);
    }

    @Override
    public List<ItemStorageInfo> getItemStorageInfo(String itemId) {
        return null;
    }

    @Override
    public List<ItemStorageRequest> getRequestHistory() {
        return null;
    }
}
