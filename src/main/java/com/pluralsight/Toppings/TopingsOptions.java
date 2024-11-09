package com.pluralsight.Toppings;

import java.util.HashSet;
import java.util.Set;

public class TopingsOptions {
    public Set<String> mainMenue(){
        Set<String> menuOptions = new HashSet<>();
        menuOptions.add("sandwich");
        menuOptions.add("drink");
        menuOptions.add("chips");
        menuOptions.add("checkout");
        menuOptions.add("cancel order");

        System.out.println("Sandwich");
        System.out.println("Drink");
        System.out.println("Chips");
        System.out.println("Checkout");
        System.out.println("Cancel Order");

        return menuOptions;
    }

    public void sandwichSizeType(){
        System.out.println("[4] - 4 Inch");
        System.out.println("[8] - 8 Inch");
        System.out.println("[12] - 12 Inch");
    }

    public Set<String> breadTypes(){
        Set<String> breadTypes = new HashSet<>();
        breadTypes.add("white");
        breadTypes.add("wheat");
        breadTypes.add("rye");
        breadTypes.add("wrap");

        System.out.println("White");
        System.out.println("Wheat");
        System.out.println("Rye");
        System.out.println("Wrap");

        return breadTypes;
    }

    public void meatTypes(){
        System.out.println("Steak");
        System.out.println("Ham");
        System.out.println("Salami");
        System.out.println("Roast Beef");
        System.out.println("Chicken");
        System.out.println("Bacon");
    }

    public void cheeseTypes(){
        System.out.println("American");
        System.out.println("Provolone");
        System.out.println("Cheddar");
        System.out.println("Swiss");
    }

    public void regularToppingsType(){
        System.out.println("Lettuce");
        System.out.println("Peppers");
        System.out.println("Onions");
        System.out.println("Tomatoes");
        System.out.println("Jalapenos");
        System.out.println("Cucumbers");
        System.out.println("Pickles");
        System.out.println("Guacamole");
        System.out.println("Mushrooms");
    }
}
