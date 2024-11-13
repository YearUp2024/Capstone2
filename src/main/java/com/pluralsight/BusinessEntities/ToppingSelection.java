package com.pluralsight.BusinessEntities;

import java.util.List;

public class ToppingSelection {
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
