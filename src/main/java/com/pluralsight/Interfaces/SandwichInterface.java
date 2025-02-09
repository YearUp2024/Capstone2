package com.pluralsight.Interfaces;

import com.pluralsight.BusinessEntities.ToppingSelection;
import com.pluralsight.BusinessEntities.Sandwich;
import com.pluralsight.Console;
import com.pluralsight.OrderScreen.SaveOrder;
import com.pluralsight.OrderScreen.Chips;
import com.pluralsight.OrderScreen.Drink;
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
    SaveOrder saveOrder = new SaveOrder();

    /**
     * This method is getting the Sandwich size. The users are given 3 sizes (4 inch, 8 inch, 12 inch),
     * and the users are able to choose a size form that.
     * @return
     */
    private int promptForSandwichSize() {
        int sandwichSize = 0;
        do{
            System.out.println("\nWhat size Sandwich do you want?");
            toppingsOptions.sandwichSizeType();

            try{
                sandwichSize = Console.PromptForInt("Enter your choice: ");
                if(sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12){
                    System.out.println("\n-----------------------------------------------------------");
                    System.out.println("          Please enter a valid size: 4, 8, or 12.");
                    System.out.println("-----------------------------------------------------------");
                }
            }catch(Exception e){
                System.out.println("\n-----------------------------------------------------------");
                System.out.println("          Please enter a valid size: 4, 8, or 12.");
                System.out.println("-----------------------------------------------------------");
            }
        }while(sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12);
        return sandwichSize;
    }

    /**
     * This is the main method. This method is calling all the other methods and putting them in one place.
     * @return
     */
    public List<Sandwich> orderSandwich() {
        int numberOfSandwiches = 0;
        boolean isValidInput = false;

        //This is make sure that the users enters a valid input. If they don't they will be prompted over and over again for a valid input.
        do {
            try {
                numberOfSandwiches = Console.PromptForInt("How many sandwiches do you want? ");

                if (numberOfSandwiches >= 1) {
                    isValidInput = true;
                } else {
                    System.out.println("\n---------------------------------------------------------------------");
                    System.out.println("         Please enter a valid number greater than zero.");
                    System.out.println("---------------------------------------------------------------------\n");
                }
            } catch (Exception e) {
                System.out.println("\n-----------------------------------------------------------");
                System.out.println("     Your input is invalid. Please enter a number.");
                System.out.println("-----------------------------------------------------------\n");
            }
        } while (!isValidInput);

        double totalOrderCost = 0.0;
        List<Sandwich> sandwiches = new ArrayList<>();

        //This for loop is going to run for the number of Sandwiches the user want's to order.
        for (int i = 1; i <= numberOfSandwiches; i++) {
            int sandwichSize = promptForSandwichSize();
            System.out.println();

            //breadType is calling promptForBreadType() method that allow the users to choose a type of bread.
            String breadType = promptForBreadType();
            boolean toasted = Console.PromptForYesNo("Do you want your bread to be toasted:");
            System.out.println();

            //This is getting the users choice from a Regular toppings.
            ToppingSelection regularToppingsSelection = promptForRegularToppings();
            List<String> regularToppings = regularToppingsSelection.getRegularToppings();
            System.out.println();

            //This is getting the users choice from Meat types.
            ToppingSelection meatSelection = promptForMeatType();
            List<String> meatToppings = meatSelection.getPremiumToppings();
            boolean extraMeat = meatSelection.isExtraMeat();
            System.out.println();

            //This is getting the users choice from Cheese types.
            ToppingSelection cheeseSelection = promptForCheeseType();
            List<String> cheeseToppings = cheeseSelection.getPremiumToppings();
            boolean extraCheese = cheeseSelection.isExtraCheese();

            //This is getting the users choice from Sides.
            ToppingSelection sidesToppingsSelection = promptForSides();
            List<String> sidesToppings = sidesToppingsSelection.getRegularToppings();
            regularToppings.addAll(sidesToppings);
            System.out.println();

            //sandwichCost is calling calculateCost method that is calculating the cost of the sandwich.
            double sandwichCost = calculateCost(sandwichSize, meatToppings, cheeseToppings, extraMeat, extraCheese);

            //This asks the users if they want to add a Drinks if they say yes then it calls the DrinksInterface.
            boolean wantToAddDrink = Console.PromptForYesNo("Do you want to add a drink to your order?");
            Drink drink = null;
            double drinkCost = 0.0;
            if(wantToAddDrink){
                DrinksInterface drinksInterface = new DrinksInterface();
                drink = drinksInterface.orderDrinks();
                drinkCost = drink.getPrice();
            }
            System.out.println();

            //This asks the users if they want to add a Chips if they say yes then it calls the ChipsInterface.
            boolean wantToAddChips = Console.PromptForYesNo("Do you want to add chips to your order?");
            Chips chips = null;
            double chipCost = 0.0;
            if(wantToAddChips){
                ChipsInterface chipsInterface = new ChipsInterface();
                chips = chipsInterface.orderChips();
                chipCost = chips.getPrice();
            }

            //This is calculating the totalCost of Sandwich + Drink + Chips.
            double totalCost = sandwichCost + drinkCost + chipCost;
            totalOrderCost += totalCost;

            Sandwich sandwich = new Sandwich("Custom Sandwich", totalCost, 1, sandwichSize, breadType, toasted, regularToppings, meatToppings, cheeseToppings);
            sandwiches.add(sandwich);

            if (numberOfSandwiches > 1) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("                               Order Number " + i);
                System.out.println("------------------------------------------------------------------------------------");
            } else {
                System.out.println("\n------------------------------------------------------------------------------------");
                System.out.println("                        Your Order:                                  ");
                System.out.println("------------------------------------------------------------------------------------");
            }

            showOrderSummery(sandwich, drink, chips);

            if (numberOfSandwiches > 1) {
                System.out.println("----------------------------------------------------------------------------------");
                System.out.printf("                       Total for Order %d is $%.2f", i, sandwich.getPrice());
                System.out.println("\n----------------------------------------------------------------------------------");
            }

            boolean wantsToSaveOrder = Console.PromptForYesNo("\nDo you want to save your order?");
            System.out.println();

            String saveOrder = this.saveOrder.saveOrder(wantsToSaveOrder, sandwich, drink, chips);
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                              " + saveOrder);
            System.out.println("----------------------------------------------------------------------------------");
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                       Your Total for the Order is $" + totalOrderCost);
        System.out.println("----------------------------------------------------------------------------------");

        return sandwiches;
    }

    /**
     * This method is getting the Bread Type. This method displays list of Bread Types and the users are able to choose from that.
     * @return
     */
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
                        System.out.println("\n--------------------------------------------------------------");
                        System.out.println("                " + userOption + " is not a valid input.");
                        System.out.println("--------------------------------------------------------------\n");
                        System.out.println("Please select from the options: ");
                        toppingsOptions.breadTypes();
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 4.");
                    System.out.println("-------------------------------------------------------------------------------------\n");
                    System.out.println("Please select from the options: ");
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

    /**
     * This method is getting the Regular toppings. This method displays list of Regular toppings and the users are able to choose
     * from those options.
     * @return
     */
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
                    System.out.println("Please select from the Regular options:");
                    normalToppings = toppingsOptions.regularToppingsType();
                    userOption = Console.PromptForInt("Enter your choice: ");

                    if(userOption >= 1 && userOption <= normalToppings.size()){
                        validInput = true;
                    }else{
                        System.out.println("\n--------------------------------------------------------------");
                        System.out.println("                " + userOption + " is not a valid input.");
                        System.out.println("--------------------------------------------------------------\n");
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 9.");
                    System.out.println("-------------------------------------------------------------------------------------\n");
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

    /**
     * This method is getting the Meat toppings. This method displays list of Meat toppings and the users are able to choose
     * from the options.
     * @return
     */
    public ToppingSelection promptForMeatType(){
        List<String> meatToppings = new ArrayList<>();
        boolean wantMeat = Console.PromptForYesNo("Do you want Meat on your Sandwich?");
        System.out.println();
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
                        System.out.println("Please choose from Meat options:");
                        availableMeat = toppingsOptions.meatTypes();
                        userOptions = Console.PromptForInt("Enter your choice: ");

                        if(userOptions >= 1 && userOptions <= availableMeat.size()){
                            validInput = true;
                        }else{
                            System.out.println("\n--------------------------------------------------------------");
                            System.out.println("                " + userOptions + " is not a valid input.");
                            System.out.println("--------------------------------------------------------------\n");
                        }
                    }catch(Exception e){
                        System.out.println("\n-------------------------------------------------------------------------------------");
                        System.out.println("            Your input is invalid. Please enter a number between 1 and 6.");
                        System.out.println("-------------------------------------------------------------------------------------\n");
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

    /**
     * This method is getting the Cheese toppings. This method displays list of Cheese toppings and the users are able to choose
     * from the options.
     * @return
     */
    public ToppingSelection promptForCheeseType(){
        List<String> cheeseToppings = new ArrayList<>();
        boolean wantCheese = Console.PromptForYesNo("Do you want Cheese on your Sandwich?");
        boolean extraCheese = false;
        System.out.println();

        if(wantCheese){
            List<String> availableCheese;

            String userChoice;
            boolean addMoreToppings;
            do{
                int userOptions = 0;
                boolean validInput = false;

                while(!validInput){
                    try{
                        System.out.println("Please choose from the Cheese options:");
                        availableCheese = toppingsOptions.cheeseTypes();
                        userOptions = Console.PromptForInt("Enter your choice: ");

                        if(userOptions >= 1 && userOptions <= availableCheese.size()){
                            validInput = true;
                        }else{
                            System.out.println("\n--------------------------------------------------------------");
                            System.out.println("                " + userOptions + " is not a valid input.");
                            System.out.println("--------------------------------------------------------------\n");
                        }
                    }catch(Exception e){
                        System.out.println("\n-------------------------------------------------------------------------------------");
                        System.out.println("            Your input is invalid. Please enter a number between 1 and 6.");
                        System.out.println("-------------------------------------------------------------------------------------\n");
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

    /**
     * This method is getting the Sides. This method displays list of Sides options and the users are able to choose
     * from the options.
     * @return
     */
    public ToppingSelection promptForSides(){
        List<String> sidesToppings = new ArrayList<>();
        System.out.println();
        boolean wantsSides = Console.PromptForYesNo("Do you want Sauce on the side?");

        if(wantsSides){
            List<String> availableSides;

            String userChoice;
            boolean addMoreSides;

            do{
                int userOptions = 0;
                boolean validInput = false;

                while(!validInput){
                    try{
                        System.out.println("\nPlease choose from the Sides options:");
                        availableSides = toppingsOptions.regularSideTopping();
                        userOptions = Console.PromptForInt("Enter your choice: ");

                        if(userOptions >= 1 && userOptions <= availableSides.size()){
                            validInput = true;
                        }else{
                            System.out.println("\n--------------------------------------------------------------");
                            System.out.println("                " + userOptions + " is not a valid input.");
                            System.out.println("--------------------------------------------------------------");
                        }
                    }catch(Exception e){
                        System.out.println("\n-------------------------------------------------------------------------------------");
                        System.out.println("            Your input is invalid. Please enter a number between 1 and 7.");
                        System.out.println("-------------------------------------------------------------------------------------");
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

    /**
     * This method is calculating the cost of the Sandwich including anything else they added (drinks, chips).
     * @param sandwichSize
     * @param meatToppings
     * @param cheeseToppings
     * @param extraMeat
     * @param extraCheese
     * @return
     */
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

    /**
     * This method is springing out what the user has chosen.
     * @param sandwich
     * @param drink
     * @param chips
     */
    private void showOrderSummery(Sandwich sandwich, Drink drink, Chips chips) {
        System.out.println("                       Sandwich size: " + sandwich.getSize() + " inches");
        System.out.println("                       Bread Type: " + sandwich.getBreadType());
        System.out.println("                       Bread Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
        System.out.println("                       Regular toppings: " + formatToppings(sandwich.getRegularToppings()));
        System.out.println("                       Meat toppings: " + formatToppings(sandwich.getMeatToppings()));
        if (drink != null) {
            System.out.println("                       Drink: " + drink.getName());
            System.out.println("                       Drink size: " + (drink.getSize() == 1 ? "small" : drink.getSize() == 2 ? "medium" : "large"));
        }
        if(chips != null){
            System.out.println("                       Chips: " + chips.getName());
        }
    }

    /*This method is formatting how Meat and Cheese toppings are displayed.
     */
    private String formatToppings(List<String> toppings){
        if(toppings.isEmpty()){
            return "None";
        }
        return String.join(", ", toppings);
    }
}