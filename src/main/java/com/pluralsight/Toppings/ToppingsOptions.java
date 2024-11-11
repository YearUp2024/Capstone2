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
        meatToppings.add("roast beef");
        meatToppings.add("chicken");
        meatToppings.add("bacon");

        System.out.println("Steak");
        System.out.println("Ham");
        System.out.println("Salami");
        System.out.println("Roast Beef");
        System.out.println("Chicken");
        System.out.println("Bacon");

        return meatToppings;
    }

    public List<String> cheeseTypes(){
        List<String> cheeseToppings = new ArrayList<>();
        cheeseToppings.add("american");
        cheeseToppings.add("provolone");
        cheeseToppings.add("cheddar");
        cheeseToppings.add("swiss");

        System.out.println("American Cheese");
        System.out.println("Provolone Cheese");
        System.out.println("Cheddar Cheese");
        System.out.println("Swiss Cheese");

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

        System.out.println("Lettuce");
        System.out.println("Peppers");
        System.out.println("Onions");
        System.out.println("Tomatoes");
        System.out.println("Jalapenos");
        System.out.println("Cucumbers");
        System.out.println("Pickles");
        System.out.println("Guacamole");
        System.out.println("Mushrooms");

        return regularToppings;
    }

    public List<String> regularSaucesTopping(){
        List<String> regularSauces = new ArrayList<>();
        regularSauces.add("mayo");
        regularSauces.add("mustard");
        regularSauces.add("ketchup");
        regularSauces.add("ranch");
        regularSauces.add("thousand island");
        regularSauces.add("vinaigrette");

        System.out.println("Mayo");
        System.out.println("Mustard");
        System.out.println("Ketchup");
        System.out.println("Ranch");
        System.out.println("Thousand Island");
        System.out.println("Vinaigrette");

        return regularSauces;
    }

    public List<String> sidesToppings(){
        List<String> sides = new ArrayList<>();
        sides.add("au jus");
        sides.add("sauce");

        System.out.println("Au Jus");
        System.out.println("Sauce");

        return sides;
    }
}
