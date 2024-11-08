package com.pluralsight.OrderScreen;

import com.pluralsight.Console;
import com.pluralsight.Toppings.TopingsOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SandwichInterface {
    private static final double BASE_COST_4 = 5.50;
    private static final double BASE_COST_8 = 7.00;
    private static final double BASE_COST_12 = 8.50;
    private static final double MEAT_COST_4 = 1.00;
    private static final double MEAT_COST_8 = 2.00;
    private static final double MEAT_COST_12 = 3.00;
    private static final double EXTRA_MEAT_COST_4 = 0.50;
    private static final double EXTRA_MEAT_COST_8 = 1.00;
    private static final double EXTRA_MEAT_COST_12 = 1.50;
    private static final double CHEESE_COST_4 = 0.75;
    private static final double CHEESE_COST_8 = 1.50;
    private static final double CHEESE_COST_12 = 2.25;
    private static final double EXTRA_CHEESE_COST_4 = 0.30;
    private static final double EXTRA_CHEESE_COST_8 = 0.60;
    private static final double EXTRA_CHEESE_COST_12 = 0.90;

    TopingsOptions topingsOptions = new TopingsOptions();

    public void orderSandwich(){
        int sandwichSize = promptForSandwichSize();
        String breadType = promptForBreadType();
        boolean toasted = Console.PromptForYesNo("Do you want your bread to be toasted: ");
        List<String> regularToppings = promptForToppings("regular");
        List<String> premiumToppings = new ArrayList<>();

        String meat = Console.PromptForString("Do you want Meat? ");
        if(meat.equalsIgnoreCase("Yes")){
            premiumToppings.addAll(promptForToppings("meat"));
        }

        String cheese = Console.PromptForString("Do you want Cheese? ");
        if(cheese.equalsIgnoreCase("Yes")){
            premiumToppings.addAll(promptForToppings("cheese"));
        }

        boolean extraMeat = Console.PromptForYesNo("Do you want extra Meat ");
        boolean extraCheese = Console.PromptForYesNo("Do you want extra Cheese ");
        System.out.println(regularToppings);
        System.out.println(premiumToppings);

        AddSandwich addSandwich = new AddSandwich("Custom Sandwich", 0, 1, sandwichSize, breadType, toasted, 0, regularToppings, premiumToppings);
//        addSandwich.getCost(calculateCost(sandwichSize, regularToppings, premiumToppings, extraMeat, extraCheese));
    }

    private int promptForSandwichSize() {
        System.out.println("What size Sandwich do you want?");
        topingsOptions.sandwichSizeType();
        return Console.PromptForInt("Enter your choice: ");
    }

    public String promptForBreadType(){
        System.out.println("What type of bread do you want?");
        topingsOptions.breadTypes();
        return Console.PromptForString("Enter Bread type: ");
    }

    public List<String> promptForToppings(String type){
        List<String> toppings = new ArrayList<>();

        String moreOptions;
        do{
            if(type.equalsIgnoreCase("regular")){
                topingsOptions.regularToppingsType();
            }else if(type.equalsIgnoreCase("meat")){
                topingsOptions.meatTypes();
            }else if(type.equalsIgnoreCase("cheese")){
                topingsOptions.cheeseTypes();
            }

            List<String> newToopings = Arrays.asList(Console.PromptForString("Enter your Toppings: "));
            toppings.addAll(newToopings);
            moreOptions = Console.PromptForString("Do you want to add more toppings? ");
        }while(!moreOptions.equalsIgnoreCase("NO"));
        return toppings;
    }

//    public double calculateCost(int sandwichSize, List<String> premiumToopings, List<String> premiumToopings, boolean extraMeat, boolean extraCheese){
//
//    }















//    public void orderSandwich(){
//        System.out.println("What size Sandwich do you want?");
//        topingsOptions.sandwichSizeType();
//        int sandWichSize = Console.PromptForInt("Enter your choice: ");
//        System.out.println();
//
//        System.out.println("What type of bread do you want?");
//        topingsOptions.breadTypes();
//        String bread = Console.PromptForString("Enter Bread type: ");
//        boolean tostedBread = Console.PromptForYesNo("Do you want your bread to be toasted: ");
//        System.out.println();
//
//        List<String> regularToppings = new ArrayList<>();
//
//        String moreOptions;
//        do{
//            System.out.println("What Toppings do you want?");
//            topingsOptions.regularToppingsType();
//            List<String> newRegularTopings = Arrays.asList(Console.PromptForString("Enter toppings ex: Lettuce, Mushrooms: "));
//            regularToppings.addAll(newRegularTopings);
//            moreOptions = Console.PromptForString("Do you want to add more toppings? ");
//        }while(!moreOptions.equalsIgnoreCase("NO"));
//
//        List<String> premiumTopings = new ArrayList<>();
//        String meatToppings = Console.PromptForString("Do you want Meat? ");
//        if (meatToppings.equalsIgnoreCase("Yes")) {
//            String morePremiumOptions;
//            do {
//                System.out.println("What Toppings do you want?");
//                topingsOptions.meatTypes();
//                List<String> newPremiumToppings = Arrays.asList(Console.PromptForString("Enter toppings ex: Steak, Ham: "));
//                premiumTopings.addAll(newPremiumToppings);
//                morePremiumOptions = Console.PromptForString("Do you want to add more toppings? ");
//                System.out.println();
//            } while (!morePremiumOptions.equalsIgnoreCase("No"));
//        }
//
//        String cheeseToppings = Console.PromptForString("Do you want Cheese? ");
//        if (cheeseToppings.equalsIgnoreCase("Yes")) {
//            String morePremiumOptions;
//            do {
//                System.out.println("What Toppings do you Cheese?");
//                topingsOptions.cheeseTypes();
//                List<String> newPremiumToppings = Arrays.asList(Console.PromptForString("Enter toppings ex: Swiss, Cheddar: "));
//                premiumTopings.addAll(newPremiumToppings);
//                morePremiumOptions = Console.PromptForString("Do you want to add more toppings? ");
//                System.out.println();
//            } while (!morePremiumOptions.equalsIgnoreCase("No"));
//        }
//    }
//
//    public double calculateCost(int size, List<String> premiumToopings, boolean extraMeat, boolean extraCheese){
//        double baseCost = 0;
//        switch(size){
//            case 4:
//                baseCost = 5.50;
//                break;
//            case 8:
//                baseCost = 7.00;
//                break;
//            case 12:
//                baseCost = 8.50;
//                break;
//        }
//        double meatCost = premiumToopings.size() * (size == 4 ? 1.00 : size == 8 ? 2.00 : 3.00);
//        double extraMeatCost = extraMeat ? (size == 4 ? .50 : size == 8 ? 1.00 : 1.50) : 0;
//        double cheeseCost = extraCheese ? (size == 4 ? .75 : size == 8 ? 1.50 : 2.25) : 0;
//        double extraCheeseCost = extraCheese ? (size == 4 ? .30 : size == 8 ? 0.60 : 0.90) : 0;
//        return baseCost + meatCost + extraMeatCost + cheeseCost + extraCheeseCost;
//    }
}
