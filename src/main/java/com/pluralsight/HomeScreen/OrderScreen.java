package com.pluralsight.HomeScreen;

import com.pluralsight.Console;
import com.pluralsight.OrderScreen.SandwichInterface;
import com.pluralsight.Toppings.ToppingsOptions;
import java.util.List;

public class OrderScreen {
    SandwichInterface sandwichInterface = new SandwichInterface();
    ToppingsOptions toppingsOptions = new ToppingsOptions();

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
                    System.out.println("\nYour input is invalid. Please enter a number between 1 and 5.");
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
                    System.out.println("Add Drink");
                    System.out.println();
                    break;
                case "chips":
                    System.out.println("Add Chips");
                    System.out.println();
                    break;
                case "checkout":
                    System.out.println("Checkout");
                    System.out.println();
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
