package com.pluralsight.OrderScreen;

import com.pluralsight.BusinessEntities.ToppingSelection;
import com.pluralsight.BusinessEntities.Sandwich;
import com.pluralsight.Console;
import com.pluralsight.Toppings.ToppingsOptions;
import java.util.*;

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

    ToppingsOptions toppingsOptions = new ToppingsOptions();
    Checkout checkout = new Checkout();

    private int promptForSandwichSize() {
        int sandwichSize = 0;
        do{
            System.out.println("\nWhat size Sandwich do you want?");
            toppingsOptions.sandwichSizeType();

            try{
                sandwichSize = Console.PromptForInt("Enter your choice: ");
                if(sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12){
                    System.out.println("\nPlease enter a valid size: 4, 8, or 12.");
                }
            }catch(Exception e){
                System.out.println("\nPlease enter a valid size: 4, 8, or 12.");
            }
        }while(sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12);
        return sandwichSize;
    }

    public List<Sandwich> orderSandwich() {
        int numberOfSandwich = Console.PromptForInt("How many sandwiches do you want? ");
        double totalOrderCost = 0.0;
        List<Sandwich> sandwiches = new ArrayList<>();

        for (int i = 1; i <= numberOfSandwich; i++) {
            int sandwichSize = promptForSandwichSize();
            System.out.println();

            String breadType = promptForBreadType();
            boolean toasted = Console.PromptForYesNo("Do you want your bread to be toasted:");

            System.out.println();

            ToppingSelection regularToppingsSelection = promptForRegularToppings();
            List<String> regularToppings = regularToppingsSelection.getRegularToppings();
            System.out.println();

            ToppingSelection meatSelection = promptForMeatType();
            List<String> meatToppings = meatSelection.getPremiumToppings();
            boolean extraMeat = meatSelection.isExtraMeat();
            System.out.println();

            ToppingSelection cheeseSelection = promptForCheeseType();
            List<String> cheeseToppings = cheeseSelection.getPremiumToppings();
            boolean extraCheese = cheeseSelection.isExtraCheese();

            ToppingSelection sidesToppingsSelection = promptForSides();
            List<String> sidesToppings = sidesToppingsSelection.getRegularToppings();
            regularToppings.addAll(sidesToppings);
            System.out.println();

            double sandwichCost = calculateCost(sandwichSize, meatToppings, cheeseToppings, extraMeat, extraCheese);

            boolean wantToAddDrink = Console.PromptForYesNo("Do you want to add a drink to your order?");
            Drink drink = null;
            double drinkCost = 0.0;
            if(wantToAddDrink){
                DrinksInterface drinksInterface = new DrinksInterface();
                drink = drinksInterface.orderDrinks();
                drinkCost = drink.getPrice();
            }
            double totalCost = sandwichCost + drinkCost;
            totalOrderCost += totalCost;

            Sandwich sandwich = new Sandwich("Custom Sandwich", totalCost, 1, sandwichSize, breadType, toasted, regularToppings, meatToppings, cheeseToppings);
            sandwiches.add(sandwich);

            if (numberOfSandwich > 1) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("                               Order Number " + i);
                System.out.println("------------------------------------------------------------------------------------");
            } else {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("                               Your Order:                                  ");
                System.out.println("------------------------------------------------------------------------------------");
            }

            showOrderSummery(sandwich);

            if (numberOfSandwich > 1) {
                System.out.println("----------------------------------------------------------------------------------");
                System.out.printf("                       Total for Order %d is $%.2f", i, sandwich.getPrice());
                System.out.println("\n----------------------------------------------------------------------------------");
            }

            boolean wantsToSaveOrder = Console.PromptForYesNo("\nDo you want to save your order? ");
            String saveOrder = checkout.saveOrder(wantsToSaveOrder, sandwich, drink);
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                     " + saveOrder);
            System.out.println("----------------------------------------------------------------------------------");

        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                       Your Total for the Order is $" + totalOrderCost);
        System.out.println("----------------------------------------------------------------------------------");

        return sandwiches;
    }

    public String promptForBreadType(){
        System.out.println("What type of bread do you want?");
        List<String> breadType = toppingsOptions.breadTypes();

        String userChoice = "";
        do{
            int userOption = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    userOption = Console.PromptForInt("Enter your choice: ");
                    if(userOption >= 1 && userOption <= 4){
                        validInput = true;
                    }else{
                        System.out.println("\nPlease select from the options: ");
                        toppingsOptions.breadTypes();
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 4.");
                    System.out.println("-------------------------------------------------------------------------------------\n");
                    System.out.println("Please select from the Options: ");
                    toppingsOptions.breadTypes();
                }
            }

            switch(userOption){
                case 1:
                    userChoice = "white";
                    break;
                case 2:
                    userChoice = "Wheat";
                    break;
                case 3:
                    userChoice = "Rye";
                    break;
                case 4:
                    userChoice = "Wrap";
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
                    break;
            }
        }while(!breadType.contains(userChoice));
        return userChoice;
    }

    public ToppingSelection promptForRegularToppings(){
        List<String> normalToppings;
        List<String> selectedToppings = new ArrayList<>();

        String userChoice;
        boolean addMoreToppings;
        do{
            int userOption = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    System.out.println("Which toppings do you want?");
                    normalToppings = toppingsOptions.regularToppingsType();
                    userOption = Console.PromptForInt("Enter your choice: ");

                    if(userOption >= 1 && userOption <= normalToppings.size()){
                        validInput = true;
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 9.");
                    System.out.println("-------------------------------------------------------------------------------------\n");
                    System.out.println("Please select from the options:");
                }
            }

            switch(userOption){
                case 1:
                    userChoice = "lettuce";
                    selectedToppings.add(userChoice);
                    break;
                case 2:
                    userChoice = "peppers";
                    selectedToppings.add(userChoice);
                    break;
                case 3:
                    userChoice = "onions";selectedToppings.add(userChoice);
                    break;
                case 4:
                    userChoice = "tomatoes";
                    selectedToppings.add(userChoice);
                    break;
                case 5:
                    userChoice = "jalapenos";
                    selectedToppings.add(userChoice);
                    break;
                case 6:
                    userChoice = "cucumbers";
                    selectedToppings.add(userChoice);
                    break;
                case 7:
                    userChoice = "pickles";
                    selectedToppings.add(userChoice);
                    break;
                case 8:
                    userChoice = "guacamole";
                    selectedToppings.add(userChoice);
                    break;
                case 9:
                    userChoice = "mushrooms";
                    selectedToppings.add(userChoice);
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
            }
            addMoreToppings = Console.PromptForYesNo("Do you want to add more toppings?");
        }while(addMoreToppings);
        return new ToppingSelection(selectedToppings, new ArrayList<>(), false, false);
    }

    public ToppingSelection promptForMeatType(){
        List<String> meatToppings = new ArrayList<>();
        boolean wantMeat = Console.PromptForYesNo("Do you want Meat on your Sandwich?");
        boolean extraMeat = false;

        if(wantMeat){
            List<String> availableMeat;

            String userChoice;
            boolean addMoreMeat;
            do{
                int userOptions = 0;
                boolean validInput = false;

                while(!validInput){
                    try{
                        System.out.println("Which Meat do you want?");
                        availableMeat = toppingsOptions.meatTypes();
                        userOptions = Console.PromptForInt("Enter your choice: ");

                        if(userOptions >= 1 && userOptions <= availableMeat.size()){
                            validInput = true;
                        }
                    }catch(Exception e){
                        System.out.println("\n-------------------------------------------------------------------------------------");
                        System.out.println("            Your input is invalid. Please enter a number between 1 and 6.");
                        System.out.println("-------------------------------------------------------------------------------------\n");
                        System.out.println("Please choose from the options:");
                    }
                }

                switch(userOptions){
                    case 1:
                        userChoice = "steak";
                        meatToppings.add(userChoice);
                        break;
                    case 2:
                        userChoice = "ham";
                        meatToppings.add(userChoice);
                        break;
                    case 3:
                        userChoice = "salami";
                        meatToppings.add(userChoice);
                        break;
                    case 4:
                        userChoice = "roast beef";
                        meatToppings.add(userChoice);
                        break;
                    case 5:
                        userChoice = "chicken";
                        meatToppings.add(userChoice);
                        break;
                    case 6:
                        userChoice = "bacon";
                        meatToppings.add(userChoice);
                        break;
                    default:
                        System.out.println("Your choice is incorrect.");
                }
                addMoreMeat = Console.PromptForYesNo("Do you want to add more Meat?");
            }while(addMoreMeat);
            extraMeat = Console.PromptForYesNo("Do you want extra Meat?");
        }
        return new ToppingSelection(new ArrayList<>(), meatToppings, extraMeat, false);
    }

    public ToppingSelection promptForCheeseType(){
        List<String> cheeseToppings = new ArrayList<>();
        boolean wantCheese = Console.PromptForYesNo("Do you want Cheese on your Sandwich?");
        boolean extraCheese = false;

        if(wantCheese){
            List<String> availableCheese;

            String userChoice;
            boolean addMoreToppings;
            do{
                int userOptions = 0;
                boolean validInput = false;

                while(!validInput){
                    try{
                        System.out.println("\nWhich Cheese do you want?");
                        availableCheese = toppingsOptions.cheeseTypes();
                        userOptions = Console.PromptForInt("Enter your choice: ");

                        if(userOptions >= 1 && userOptions <= availableCheese.size()){
                            validInput = true;
                        }
                    }catch(Exception e){
                        System.out.println("\n-------------------------------------------------------------------------------------");
                        System.out.println("            Your input is invalid. Please enter a number between 1 and 6.");
                        System.out.println("-------------------------------------------------------------------------------------\n");
                        System.out.println("Please choose from the options:");
                    }
                }

                switch(userOptions){
                    case 1:
                        userChoice = "american";
                        cheeseToppings.add(userChoice);
                        break;
                    case 2:
                        userChoice = "provolone";
                        cheeseToppings.add(userChoice);
                        break;
                    case 3:
                        userChoice = "cheddar";
                        cheeseToppings.add(userChoice);
                        break;
                    case 4:
                        userChoice = "swiss";
                        cheeseToppings.add(userChoice);
                        break;
                    default:
                        System.out.println("Your choice is incorrect.");
                }
                addMoreToppings = Console.PromptForYesNo("Do you want to add more cheese?");
            }while(addMoreToppings);
            extraCheese = Console.PromptForYesNo("Do you want extra Cheese?");
        }
        return new ToppingSelection(new ArrayList<>(), cheeseToppings, false, extraCheese);
    }

    public ToppingSelection promptForSides(){
        List<String> sidesToppings = new ArrayList<>();
        boolean wantsSides = Console.PromptForYesNo("\nDo you wants Sauce on the side?");

        if(wantsSides){
            List<String> availableSides;

            String userChoice;
            boolean addMoreSides;

            do{
                int userOptions = 0;
                boolean validInput = false;

                while(!validInput){
                    try{
                        System.out.println("\nWhich sauce do you want on the side?");
                        availableSides = toppingsOptions.regularSideTopping();
                        userOptions = Console.PromptForInt("Enter your choice: ");

                        if(userOptions >= 1 && userOptions <= availableSides.size()){
                            validInput = true;
                        }
                    }catch(Exception e){
                        System.out.println("\n-------------------------------------------------------------------------------------");
                        System.out.println("            Your input is invalid. Please enter a number between 1 and 7.");
                        System.out.println("-------------------------------------------------------------------------------------\n");
                        System.out.println("Please choose from the options:");
                    }
                }

                switch(userOptions){
                    case 1:
                        userChoice = "mayo";
                        sidesToppings.add(userChoice);
                        break;
                    case 2:
                        userChoice = "mustard";
                        sidesToppings.add(userChoice);
                        break;
                    case 3:
                        userChoice = "ketchup";
                        sidesToppings.add(userChoice);
                        break;
                    case 4:
                        userChoice = "ranch";
                        sidesToppings.add(userChoice);
                        break;
                    case 5:
                        userChoice = "thousand island";
                        sidesToppings.add(userChoice);
                        break;
                    case 6:
                        userChoice = "vinaigrette";
                        sidesToppings.add(userChoice);
                        break;
                    case 7:
                        userChoice = "au jus";
                        sidesToppings.add(userChoice);
                        break;
                    default:
                        System.out.println("Your choice is incorrect.");
                }
                addMoreSides = Console.PromptForYesNo("Do you want to add more sides?");
            }while(addMoreSides);
        }
        return new ToppingSelection(sidesToppings, new ArrayList<>(), false, false);
    }

    public double calculateCost(int sandwichSize, List<String> meatToppings, List<String> cheeseToppings, boolean extraMeat, boolean extraCheese){
        double baseCost = 0;
        double meatCost = 0;
        double extraMeatCost = 0;
        double cheeseCost = 0;
        double extraCheeseCost = 0;

        switch(sandwichSize){
            case 4:
                baseCost = baseCost4;
                meatCost = meatCost4;
                extraMeatCost = extraMeatCost4;
                cheeseCost = cheeseCost4;
                extraCheeseCost = extraCheeseCost4;
                break;
            case 8:
                baseCost = baseCost8;
                meatCost = meatCost8;
                extraMeatCost = extraMeatCost8;
                cheeseCost = cheeseCost8;
                extraCheeseCost = extraCheeseCost8;
                break;
            case 12:
                baseCost = baseCost12;
                meatCost = meatCost12;
                extraMeatCost = extraMeatCost12;
                cheeseCost = cheeseCost12;
                extraCheeseCost = extraCheeseCost12;
                break;
        }

        double totalCost = baseCost;

        totalCost += meatToppings.size() * meatCost;
        if(extraMeat){
            totalCost += extraMeatCost;
        }

        totalCost += cheeseToppings.size() * cheeseCost;
        if(extraCheese){
            totalCost += extraCheeseCost;
        }
        return totalCost;
    }

    private void showOrderSummery(Sandwich sandwich) {
        System.out.println("                            Sandwich size: " + sandwich.getSize() + " inches");
        System.out.println("                            Bread Type: " + sandwich.getBreadType());
        System.out.println("                            Bread Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
        System.out.println("                            Regular toppings: " + formtToppings(sandwich.getRegularToppings()));
        System.out.println("                            Meat toppings: " + formtToppings(sandwich.getMeatToppings()));
        System.out.println("                            Cheese toppings: " + formtToppings(sandwich.getCheeseToppings()));
    }

    private String formtToppings(List<String> toppings){
        if(toppings.isEmpty()){
            return "None";
        }
        return String.join(", ", toppings);
    }
}