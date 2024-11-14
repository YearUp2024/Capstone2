package com.pluralsight.OrderScreen;



//  Chips, Drinks, and Sandwiches should all share the ability to be on an order, and be able to calculate their own prices
// that will help simplify code in the user  interface and better organize where code that performs pricing is located...
// this might be accomplished by having them all inherit from MenuItem, and then let an order have menuitems.

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
