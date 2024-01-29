package com.trlobyte.wms.warehouseservice.repositories;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;


@Document(collation = "itemStorageRequests")
public class ItemStorageRequestEntity {
    @Id
    private String id;
    @Version
    private Integer version;
    @Indexed(unique = true)
    private final int operationId;
    private final int itemId;
    private final String fromLocationId;
    private final int itemQty;
    private final String storagePlaceId;
    private final Timestamp requestedTs;
    private Timestamp acceptedTs;

    public ItemStorageRequestEntity(int operationId, int itemId, String fromLocationId, int itemQty, String storagePlaceId, Timestamp requestedTs) {
        this.operationId = operationId;
        this.itemId = itemId;
        this.fromLocationId = fromLocationId;
        this.itemQty = itemQty;
        this.storagePlaceId = storagePlaceId;
        this.requestedTs = requestedTs;
    }

    public ItemStorageRequestEntity(int operationId, int itemId, String fromLocationId, int itemQty, String storagePlaceId, Timestamp requestedTs, Timestamp acceptedTs) {
        this.operationId = operationId;
        this.itemId = itemId;
        this.fromLocationId = fromLocationId;
        this.itemQty = itemQty;
        this.storagePlaceId = storagePlaceId;
        this.requestedTs = requestedTs;
        this.acceptedTs = acceptedTs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getOperationId() {
        return operationId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getFromLocationId() {
        return fromLocationId;
    }

    public int getItemQty() {
        return itemQty;
    }

    public String getStoragePlaceId() {
        return storagePlaceId;
    }

    public Timestamp getRequestedTs() {
        return requestedTs;
    }

    public Timestamp getAcceptedTs() {
        return acceptedTs;
    }

    public void setAcceptedTs(Timestamp acceptedTs) {
        this.acceptedTs = acceptedTs;
    }
}
