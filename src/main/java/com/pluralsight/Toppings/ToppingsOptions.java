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

        System.out.println("[1] - Sandwich");
        System.out.println("[2] - Drink");
        System.out.println("[3] - Chips");
        System.out.println("[4] - Checkout");
        System.out.println("[5] - Cancel Order");

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

        System.out.println("[1] - White");
        System.out.println("[2] - Wheat");
        System.out.println("[3] - Rye");
        System.out.println("[4] - Wrap");

        return breadTypes;
    }

    public List<String> meatTypes(){
        List<String> meatToppings = new ArrayList<>();
        meatToppings.add("steak");
        meatToppings.add("ham");
        meatToppings.add("salami");
        meatToppings.add("roast beef");
        meatToppings.add("chicken");
        meatToppings.add("bacon");

        System.out.println("[1] - Steak");
        System.out.println("[2] - Ham");
        System.out.println("[3] - Salami");
        System.out.println("[4] - Roast Beef");
        System.out.println("[5] - Chicken");
        System.out.println("[6] - Bacon");

        return meatToppings;
    }

    public List<String> cheeseTypes(){
        List<String> cheeseToppings = new ArrayList<>();
        cheeseToppings.add("american");
        cheeseToppings.add("provolone");
        cheeseToppings.add("cheddar");
        cheeseToppings.add("swiss");

        System.out.println("[1] - American Cheese");
        System.out.println("[2] - Provolone Cheese");
        System.out.println("[3] - Cheddar Cheese");
        System.out.println("[4] - Swiss Cheese");

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

        System.out.println("[1] - Lettuce");
        System.out.println("[2] - Peppers");
        System.out.println("[3] - Onions");
        System.out.println("[4] - Tomatoes");
        System.out.println("[5] - Jalapenos");
        System.out.println("[6] - Cucumbers");
        System.out.println("[7] - Pickles");
        System.out.println("[8] - Guacamole");
        System.out.println("[9] - Mushrooms");

        return regularToppings;
    }

    public List<String> regularSideTopping(){
        List<String> regularSauces = new ArrayList<>();
        regularSauces.add("mayo");
        regularSauces.add("mustard");
        regularSauces.add("ketchup");
        regularSauces.add("ranch");
        regularSauces.add("thousand island");
        regularSauces.add("vinaigrette");
        regularSauces.add("au jus");

        System.out.println("[1] - Mayo");
        System.out.println("[2] - Mustard");
        System.out.println("[3] - Ketchup");
        System.out.println("[4] - Ranch");
        System.out.println("[5] - Thousand Island");
        System.out.println("[6] - Vinaigrette");
        System.out.println("[7] - Au Jus");

        return regularSauces;
    }

    public List<String> drinksOptions(){
        List<String> drinks = new ArrayList<>();
        drinks.add("pepsi");
        drinks.add("sprite");
        drinks.add("red bull");
        drinks.add("gatorade");
        drinks.add("arizona");
        drinks.add("coca cola");
        drinks.add("coke");

        System.out.println("[1] - Pepsi");
        System.out.println("[2] - Sprite");
        System.out.println("[3] - Red Bull");
        System.out.println("[4] - Gatorade");
        System.out.println("[5] - Arizona");
        System.out.println("[6] - Coca Cola");
        System.out.println("[7] - Coke");

        return drinks;
    }
}
