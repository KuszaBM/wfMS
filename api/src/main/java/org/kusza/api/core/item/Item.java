package org.kusza.api.core.item;

public class Item {
    private final int itemId;
    private final String name;
    private final int weight;
    private final double price;


    public Item(int itemId, String name, int weight, double price) {
        this.itemId = itemId;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Item() {
        this.itemId = 0;
        this.name = null;
        this.weight = 0;
        this.price = 0.0;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}
