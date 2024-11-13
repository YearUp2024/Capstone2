package com.pluralsight.HomeScreen;

import com.pluralsight.Console;
import com.pluralsight.BusinessEntities.Sandwich;
import com.pluralsight.OrderScreen.Checkout;
import com.pluralsight.OrderScreen.DrinksInterface;
import com.pluralsight.OrderScreen.SandwichInterface;
import com.pluralsight.Toppings.ToppingsOptions;


public class OrderScreen {
    SandwichInterface sandwichInterface = new SandwichInterface();
    ToppingsOptions toppingsOptions = new ToppingsOptions();
    DrinksInterface drinks = new DrinksInterface();
    Checkout checkout = new Checkout();
    Sandwich sandwich;
    DrinksInterface drinksInterface = new DrinksInterface();

    public void userOrder() {
        //List<String> menuOptions;
        String order = "";

        do {
            int userChoice = 0;
            boolean validInput = false;
            while(!validInput){
                System.out.println("Please choose from the options: ");
                toppingsOptions.mainMenue();

                try{
                    userChoice = Console.PromptForInt("Please enter your Choice: ");
                    if(userChoice >= 1 && userChoice <= 5){
                        validInput = true;
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 5.");
                    System.out.println("-------------------------------------------------------------------------------------\n");
                }
            }

            switch(userChoice){
                case 1:
                    order = "sandwich";
                    break;
                case 2:
                    order = "drink";
                    break;
                case 3:
                    order = "chips";
                    break;
                case 4:
                    order = "checkout";
                    break;
                case 5:
                    order = "cancel order";
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
                    continue;
            }
            System.out.println();

            switch (order) {
                case "sandwich":
                    sandwichInterface.orderSandwich();
                    System.out.println();
                    break;
                case "drink":
                    drinksInterface.addDrinks();
                    System.out.println();
                    break;
                case "chips":
                    System.out.println("Add Chips");
                    System.out.println();
                    break;
                case "checkout":
                    if(sandwich != null){
                        boolean wantsToSaveOrder = Console.PromptForYesNo("Do you want to save your order? ");
                        String saveOrder = checkout.saveOrder(wantsToSaveOrder, sandwich);
                    }
                    break;
                case "cancel order":
                    System.out.println("Your order is canceled.");
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
                    break;
            }
        } while (!order.equalsIgnoreCase("cancel order"));
    }
}
