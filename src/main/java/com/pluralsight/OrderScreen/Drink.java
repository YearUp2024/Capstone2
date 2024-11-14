package com.pluralsight.OrderScreen;

public class Drink {
    private String name;
    private int size;
    private double price;

    public Drink(String name, int size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}