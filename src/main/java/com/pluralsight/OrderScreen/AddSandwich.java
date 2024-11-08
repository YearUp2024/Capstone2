package com.pluralsight.OrderScreen;

import java.util.List;

public class AddSandwich extends MenuItem{
    private int size;
    private String breadType;
    private boolean toasted;
    private double cost;
    private List<String> regularToppings;
    private List<String> premiumToppings;

    public AddSandwich(String name, double price, int quantity, int size, String breadType, boolean toasted, double cost, List<String> regularToppings, List<String> premiumToppings) {
        super(name, price, quantity);
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.cost = cost;
        this.regularToppings = regularToppings;
        this.premiumToppings = premiumToppings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}