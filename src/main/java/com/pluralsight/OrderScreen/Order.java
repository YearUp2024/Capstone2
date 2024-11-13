package com.pluralsight.OrderScreen;

import com.pluralsight.BusinessEntities.Sandwich;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void addSandwich(Sandwich sandwich) {
        this.sandwiches.add(sandwich);
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }
}