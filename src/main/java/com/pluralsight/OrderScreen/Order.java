package com.pluralsight.OrderScreen;

import com.pluralsight.BusinessEntities.Sandwich;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
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

    public List<Drink> getChips() {
        return drinks;
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public void addChips(Chips chips) {
        this.chips.add(chips);
    }
}