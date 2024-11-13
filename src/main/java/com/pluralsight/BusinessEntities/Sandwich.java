package com.pluralsight.BusinessEntities;

import java.util.List;

public class Sandwich extends MenuItem {
    private int size;
    private String breadType;
    private boolean toasted;
    private List<String> regularToppings;
    private List<String> meatToppings;
    private List<String> cheeseToppings;

    public Sandwich(String name, double price, int quantity, int size, String breadType, boolean toasted, List<String> regularToppings, List<String> meatToppings, List<String> cheeseToppings) {
        super(name, price, quantity);
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.regularToppings = regularToppings;
        this.meatToppings = meatToppings;
        this.cheeseToppings = cheeseToppings;
    }

    public int getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return toasted;
    }

    public List<String> getRegularToppings() {
        return regularToppings;
    }

    public List<String> getMeatToppings() {
        return meatToppings;
    }

    public List<String> getCheeseToppings() {
        return cheeseToppings;
    }
}