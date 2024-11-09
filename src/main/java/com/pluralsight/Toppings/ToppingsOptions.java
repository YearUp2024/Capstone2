package com.pluralsight.Toppings;

import java.util.ArrayList;
import java.util.List;

public class ToppingsOptions {
    public List<String> mainMenue(){
        List<String> menuOptions = new ArrayList<>();
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

    public List<String> breadTypes(){
        List<String> breadTypes = new ArrayList<>();
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

    public List<String> meatTypes(){
        List<String> meatToppings = new ArrayList<>();
        meatToppings.add("steak");
        meatToppings.add("ham");
        meatToppings.add("salami");
        meatToppings.add("roast Beef");
        meatToppings.add("chicken");
        meatToppings.add("bacon");

        return meatToppings;
    }

    public List<String> cheeseTypes(){
        List<String> cheeseToppings = new ArrayList<>();
        cheeseToppings.add("american");
        cheeseToppings.add("provolone");
        cheeseToppings.add("cheddar");
        cheeseToppings.add("swiss");

        return cheeseToppings;
    }

    public List<String> regularToppingsType(){
        List<String> regularToppings = new ArrayList<>();
        regularToppings.add("lettuce");
        regularToppings.add("peppers");
        regularToppings.add("onions");
        regularToppings.add("tomatoes");
        regularToppings.add("jalapenos");
        regularToppings.add("cucumbers");
        regularToppings.add("pickles");
        regularToppings.add("guacamole");
        regularToppings.add("mushrooms");

        return regularToppings;
    }
}
