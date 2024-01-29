package com.trlobyte.wms.itemservice.repositories;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "items")
public class ItemEntity {

    @Id
    private String id;
    @Version
    private Integer version;
    @Indexed(unique = true)
    private final String itemId;
    private String name;
    private int weight;
    private double price;

    public ItemEntity(String itemId) {
        this.itemId = itemId;
    }

    public ItemEntity(String itemId, String name, int weight, double price) {
        this.itemId = itemId;
        this.name = name;
        this.weight = weight;
        this.price = price;
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

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
