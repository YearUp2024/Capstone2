package com.pluralsight.OrderScreen;

import java.util.List;

public class AddSandwich extends MenuItem{
    private String breadType;
    private int size;
    private boolean toasted;
    private double cost;
    private List<String> regularToppings;
    private List<String> premiumToppings;

    public AddSandwich(String name, double price, int quantity, String breadType, int size, boolean toasted, double cost, List<String> regularToppings, List<String> premiumToppings) {
        super(name, price, quantity);
        this.breadType = breadType;
        this.size = size;
        this.toasted = toasted;
        this.cost = cost;
        this.regularToppings = regularToppings;
        this.premiumToppings = premiumToppings;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public double getCost() {
        return cost;
    }

    public List<String> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<String> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public List<String> getPremiumToppings() {
        return premiumToppings;
    }

    public void setPremiumToppings(List<String> premiumToppings) {
        this.premiumToppings = premiumToppings;
    }
}


