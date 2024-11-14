package com.pluralsight.OrderScreen;

public class Chips {
    private String name;
    private double price;

    public Chips(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
