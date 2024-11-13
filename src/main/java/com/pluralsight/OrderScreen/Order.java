package com.pluralsight.OrderScreen;

import com.pluralsight.BusinessEntities.Sandwich;

import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<DrinksInterface> drinks;

    public Order(List<Sandwich> sandwiches, List<DrinksInterface> drinks) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void addSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<DrinksInterface> getDrinks() {
        return drinks;
    }

    public void addDrinks(List<DrinksInterface> drinks) {
        this.drinks = drinks;
    }
}
