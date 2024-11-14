package com.pluralsight.OrderScreen;

import com.pluralsight.Toppings.ToppingsOptions;
import com.pluralsight.Console;
import java.util.List;

public class DrinksInterface {
    private static final double small = 2.00;
    private static final double medium = 2.50;
    private static final double large = 3.00;

    ToppingsOptions toppingsOptions = new ToppingsOptions();

    public Drink orderDrinks(){
        List<String> drinkType;
        int size = 0;
        double price = 0.0;
        String drinkName = "";
        boolean addMoreDrinks;
        do{
            int userOption = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    System.out.println("Which drink do you want?");
                    drinkType = toppingsOptions.drinksOptions();
                    userOption = Console.PromptForInt("Enter your choice: ");

                    size = Console.PromptForInt("What size do you want? (1: Small, 2: Medium, 3: Large) ");

                    if(userOption >= 1 && userOption <= drinkType.size()){
                        validInput = true;
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 7.");
                    System.out.println("-------------------------------------------------------------------------------------\n");
                    System.out.println("Please select from the Options: ");
                    toppingsOptions.drinksOptions();
                }
            }

            switch(userOption){
                case 1:
                    drinkName = "pepsi";
                    break;
                case 2:
                    drinkName = "sprite";
                    break;
                case 3:
                    drinkName = "red bull";
                    break;
                case 4:
                    drinkName = "gatorade";
                    break;
                case 5:
                    drinkName = "arizona";
                    break;
                case 6:
                    drinkName = "coca cola";
                    break;
                case 7:
                    drinkName = "coke";
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
            }

            if(size == 1){
                price = small;
            }else if(size == 2){
                price = medium;
            }else if(size == 3){
                price = large;
            }
            addMoreDrinks = Console.PromptForYesNo("Do you want to add more Drinks?");
        }while(addMoreDrinks);
        return new Drink(drinkName, size, price);
    }
}