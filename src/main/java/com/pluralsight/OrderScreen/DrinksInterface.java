package com.pluralsight.OrderScreen;

import com.pluralsight.Toppings.ToppingsOptions;
import com.pluralsight.Console;

import java.util.ArrayList;
import java.util.List;

public class DrinksInterface {
    private static final double small = 2.00;
    private static final double medium = 2.50;
    private static final double large = 3.00;

    ToppingsOptions toppingsOptions = new ToppingsOptions();

    public Drink orderDrinks(){
        List<String> drinkType;
        String size = "";
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

                    size = Console.PromptForString("What size do you want? (Small, Medium, Large) ");

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
            if(size.equalsIgnoreCase("small")){
                price = 2.0;
            }else if(size.equalsIgnoreCase("medium")){
                price = 2.50;
            }
            if(size.equalsIgnoreCase("Larger")){
                price = 3.0;
            }
            addMoreDrinks = Console.PromptForYesNo("Do you want to add more Drinks?");
        }while(addMoreDrinks);
        return new Drink(drinkName, size, price);
    }
}
