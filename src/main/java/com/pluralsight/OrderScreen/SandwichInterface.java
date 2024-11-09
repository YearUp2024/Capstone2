package com.pluralsight.OrderScreen;

import com.pluralsight.Console;
import com.pluralsight.Toppings.TopingsOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SandwichInterface {
    private static final double baseCost4 = 5.50;
    private static final double baseCost8 = 7.00;
    private static final double baseCost12 = 8.50;
    private static final double meatCost4 = 1.00;
    private static final double meatCost8 = 2.00;
    private static final double meatCost12 = 3.00;
    private static final double extraMeatCost4 = 0.50;
    private static final double extraMeatCost8 = 1.00;
    private static final double extraMeatCost12 = 1.50;
    private static final double cheeseCost4 = 0.75;
    private static final double cheeseCost8 = 1.50;
    private static final double cheeseCost12 = 2.25;
    private static final double extraCheeseCost4 = 0.30;
    private static final double extraCheeseCost8 = 0.60;
    private static final double extraCheeseCost12 = 0.90;

    TopingsOptions topingsOptions = new TopingsOptions();

    public void orderSandwich(){
        int sandwichSize = promptForSandwichSize();
        System.out.println();

        String breadType = promptForBreadType();
        boolean toasted = Console.PromptForYesNo("Do you want your bread to be toasted: ");
        System.out.println();

        List<String> regularToppings = promptForToppings("regular");
        List<String> premiumToppings = new ArrayList<>();

        System.out.println();
        boolean extraMeat = false;
        String meat = Console.PromptForString("Do you want Meat? ");
        if(meat.equalsIgnoreCase("Yes")){
            premiumToppings.addAll(promptForToppings("meat"));
            extraMeat = Console.PromptForYesNo("Do you want extra Meat ");
        }

        System.out.println();
        String cheese = Console.PromptForString("Do you want Cheese? ");
        boolean extraCheese = false;
        if(cheese.equalsIgnoreCase("Yes")){
            premiumToppings.addAll(promptForToppings("cheese"));
            extraCheese = Console.PromptForYesNo("Do you want extra Cheese ");
        }

        double totalCost = calculateCost(sandwichSize, premiumToppings, extraMeat, extraCheese);

        AddSandwich addSandwich = new AddSandwich("Custom Sandwich", totalCost, 1, sandwichSize, breadType, toasted, 0, regularToppings, premiumToppings);
    }

    private int promptForSandwichSize() {
        int sandwichSize = 0;
        do{
            System.out.println("What size Sandwich do you want?");
            topingsOptions.sandwichSizeType();
            try{
                sandwichSize = Console.PromptForInt("Enter your choice: ");
                if(sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12){
                    System.out.println("\nPlease enter a valid size: 4, 8, or 12.\n");
                }
            }catch(Exception e){
                System.out.println("\nPlease enter a valid size: 4, 8, or 12.\n");
            }
        }while(sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12);
        return sandwichSize;
    }

    public String promptForBreadType(){
        System.out.println("What type of bread do you want?");
        Set<String> breadType = topingsOptions.breadTypes();

        String userChoice = "";
        do{
            userChoice = Console.PromptForString("Enter you Bread Type: ");
            if(!breadType.contains(userChoice)){
                System.out.println("\nPlease Choose from the options.");
                topingsOptions.breadTypes();
            }
        }while(!breadType.contains(userChoice));
        return userChoice;
    }

    public List<String> promptForToppings(String type){
        List<String> toppings = new ArrayList<>();

        String moreOptions;
        do{
            if(type.equalsIgnoreCase("regular")){
                System.out.println("Which toppings do you want?" );
                topingsOptions.regularToppingsType();
            }else if(type.equalsIgnoreCase("meat")){
                System.out.println("What Meat toppings do you want?" );
                topingsOptions.meatTypes();
            }else if(type.equalsIgnoreCase("cheese")){
                System.out.println("What Cheese toppings do you want?" );
                topingsOptions.cheeseTypes();
            }

            List<String> newToopings = Arrays.asList(Console.PromptForString("Enter your Toppings: "));
            toppings.addAll(newToopings);
            moreOptions = Console.PromptForString("Do you want to add more toppings? ");
        }while(!moreOptions.equalsIgnoreCase("NO"));
        return toppings;
    }

    public double calculateCost(int sandwichSize, List<String> premiumToppings, boolean extraMeat, boolean extraCheese){
        double baseCost = 0;
        double meatCost = 0;
        double extraMeatCost = 0;
        double cheeseCost = 0;
        double extraCheeseCost = 0;

        switch(sandwichSize){
            case 4:
                baseCost = baseCost4;
                meatCost = premiumToppings.size() * meatCost4;
                extraMeatCost = extraMeat ? extraMeatCost4 : 0;
                cheeseCost = premiumToppings.size() * cheeseCost4;
                extraCheeseCost = extraCheese ? extraCheeseCost4 : 0;
                break;
            case 8:
                baseCost = baseCost8;
                meatCost = premiumToppings.size() * meatCost8;
                extraMeatCost = extraMeat ? extraMeatCost8 : 0;
                cheeseCost = premiumToppings.size() * cheeseCost8;
                extraCheeseCost = extraCheese ? extraCheeseCost8 : 0;
                break;
            case 12:
                baseCost = baseCost12;
                meatCost = premiumToppings.size() * meatCost12;
                extraMeatCost = extraMeat ? extraMeatCost12 : 0;
                cheeseCost = premiumToppings.size() * cheeseCost12;
                extraCheeseCost = extraCheese ? extraCheeseCost12 : 0;
                break;
        }
        return baseCost + meatCost + extraMeatCost + cheeseCost + extraCheeseCost;
    }
}
