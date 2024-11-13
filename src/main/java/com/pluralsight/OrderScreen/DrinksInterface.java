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

    public void addDrinks(){
        List<String> drinkType;
        List<String> selectedDrinks = new ArrayList<>();

        String userChoice = "";
        boolean addMoreDrinks;
        do{
            int userOption = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    System.out.println("Which drink do you want?");
                    drinkType = toppingsOptions.drinksOptions();
                    userOption = Console.PromptForInt("Enter your choice: ");

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
                    userChoice = "pepsi";
                    selectedDrinks.add(userChoice);
                    break;
                case 2:
                    userChoice = "sprite";
                    selectedDrinks.add(userChoice);
                    break;
                case 3:
                    userChoice = "red bull";
                    selectedDrinks.add(userChoice);
                    break;
                case 4:
                    userChoice = "gatorate";
                    selectedDrinks.add(userChoice);
                    break;
                case 5:
                    userChoice = "arizona";
                    selectedDrinks.add(userChoice);
                    break;
                case 6:
                    userChoice = "cocacola";
                    selectedDrinks.add(userChoice);
                    break;
                case 7:
                    userChoice = "coke";
                    selectedDrinks.add(userChoice);
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
            }
            addMoreDrinks = Console.PromptForYesNo("Do you want to add more Drinks?");
        }while(addMoreDrinks);
    }
}
