package com.pluralsight.BusinessEntities;

import java.util.List;

public class MenuItem {
    private String name;
    private double price;
    private int quantity;

    public MenuItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static class ToppingSelection {
        private List<String> regularToppings;
        private List<String> premiumToppings;
        private boolean extraMeat;
        private boolean extraCheese;

        public ToppingSelection(List<String> regularToppings, List<String> premiumToppings, boolean extraMeat, boolean extraCheese) {
            this.regularToppings = regularToppings;
            this.premiumToppings = premiumToppings;
            this.extraMeat = extraMeat;
            this.extraCheese = extraCheese;
        }

        public List<String> getRegularToppings() {
            return regularToppings;
        }

        public List<String> getPremiumToppings() {
            return premiumToppings;
        }

        public boolean isExtraMeat() {
            return extraMeat;
        }

        public boolean isExtraCheese() {
            return extraCheese;
        }
    }
}
