package com.pluralsight.Interfaces;

import com.pluralsight.Console;
import com.pluralsight.OrderScreen.Chips;
import com.pluralsight.Toppings.ToppingsOptions;

import java.util.List;

public class ChipsInterface {
    ToppingsOptions toppingsOptions = new ToppingsOptions();

    /**
     * This method is related to Sandwich Method. This method allows the users to Order and Chips when they are ordering a Sandwich.
     * @return
     */
    public Chips orderChips(){
        List<String> chipType;
        String name = "";
        double price = 1.50;
        boolean addMoreChips;

        do{
            int userOptions = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    System.out.println("\nPlease choose from the Chips options:");
                    chipType = toppingsOptions.chipsOptions();
                    userOptions = Console.PromptForInt("Enter your choice: ");

                    if(userOptions >= 1 && userOptions <= chipType.size()){
                        validInput = true;
                    }else{
                        System.out.println("\n-------------------------------------------------------------------------------------");
                        System.out.println("            Your input is invalid. Please enter a number between 1 and 7.");
                        System.out.println("-------------------------------------------------------------------------------------");
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 7.");
                    System.out.println("-------------------------------------------------------------------------------------");
                }
            }

            switch(userOptions){
                case 1:
                    name = "doritos";
                    break;
                case 2:
                    name = "lays";
                    break;
                case 3:
                    name = "ruffles";
                    break;
                case 4:
                    name = "cheetos";
                    break;
                case 5:
                    name = "takis";
                    break;
                case 6:
                    name = "funyuns";
                    break;
                case 7:
                    name = "pringles";
                    break;
                default:
                    System.out.println("Your input is invalid.");
            }
            addMoreChips = Console.PromptForYesNo("Do you want to add more Chips?");
        }while(addMoreChips);
        return new Chips(name, price);
    }

    /**
     * This method allows the users to only a Chips without buying Sandwich.
     * @return
     */
    public Chips buyChipsOnly(){
        List<String> chipType;
        String name = "";
        double price = 1.50;
        boolean addMoreChips;
        double totalPrice = 0.0;

        do{
            int userOption = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    System.out.println("Which chips do you want?");
                    chipType = toppingsOptions.chipsOptions();
                    userOption = Console.PromptForInt("Enter your choice: ");

                    if(userOption >= 1 && userOption <= chipType.size()){
                        validInput = true;
                    }else{
                        System.out.println("\n--------------------------------------------------------------");
                        System.out.println("                " + userOption + " is not a valid input.");
                        System.out.println("--------------------------------------------------------------\n");
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 7.");
                    System.out.println("-------------------------------------------------------------------------------------\n");
                }
            }

            switch(userOption){
                case 1:
                    name = "doritos";
                    break;
                case 2:
                    name = "lays";
                    break;
                case 3:
                    name = "ruffles";
                    break;
                case 4:
                    name = "cheetos";
                    break;
                case 5:
                    name = "takis";
                    break;
                case 6:
                    name = "funyuns";
                    break;
                case 7:
                    name = "pringles";
                    break;
                default:
                    System.out.println("Your input is invalid.");
            }
            totalPrice += price;
            addMoreChips = Console.PromptForYesNo("Do you want to add more chips?");
        }while(addMoreChips);

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                       Your Total for the Order is $" + totalPrice);
        System.out.println("----------------------------------------------------------------------------------");

        return new Chips(name, price);
    }
}
