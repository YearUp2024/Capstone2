package com.pluralsight.HomeScreen;

import com.pluralsight.Console;
import com.pluralsight.BusinessEntities.Sandwich;
import com.pluralsight.Interfaces.ChipsInterface;
import com.pluralsight.Interfaces.DrinksInterface;
import com.pluralsight.Interfaces.SandwichInterface;
import com.pluralsight.OrderScreen.*;
import com.pluralsight.Receipts.Checkout;
import com.pluralsight.Toppings.ToppingsOptions;
import java.util.List;


public class OrderScreen {
    SandwichInterface sandwichInterface = new SandwichInterface();
    ToppingsOptions toppingsOptions = new ToppingsOptions();
    DrinksInterface drinksInterface = new DrinksInterface();
    ChipsInterface chipsInterface = new ChipsInterface();
    Order order = new Order();
    Checkout checkout = new Checkout();

    public void userOrder() {
        String orderChoice = "";

        do {
            int userChoice = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Please choose from the options: ");
                toppingsOptions.mainMenue();

                try {
                    userChoice = Console.PromptForInt("Please enter your Choice: ");

                    if (userChoice >= 1 && userChoice <= 5) {
                        validInput = true;
                    }else{
                        System.out.println("\n--------------------------------------------------------------");
                        System.out.println("                " + userChoice + " is not a valid input.");
                        System.out.println("--------------------------------------------------------------\n");
                    }
                } catch (Exception e) {
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 5.");
                    System.out.println("-------------------------------------------------------------------------------------\n");
                }
            }

            switch (userChoice) {
                case 1:
                    orderChoice = "sandwich";
                    break;
                case 2:
                    orderChoice = "drink";
                    break;
                case 3:
                    orderChoice = "chips";
                    break;
                case 4:
                    orderChoice = "checkout";
                    break;
                case 5:
                    orderChoice = "cancel order";
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
                    continue;
            }
            System.out.println();

            switch (orderChoice) {
                case "sandwich":
                    List<Sandwich> sandwiches = sandwichInterface.orderSandwich();
                    for (Sandwich sandwich : sandwiches) {
                        order.addSandwich(sandwich);
                    }
                    System.out.println();
                    break;
                case "drink":
                    Drink drink = drinksInterface.buyDrinkOnly();
                    order.addDrink(drink);
                    System.out.println();
                    break;
                case "chips":
                    Chips chips = chipsInterface.buyChipsOnly();
                    order.addChips(chips);
                    System.out.println();
                    break;
                case "checkout":
                    if(order.getSandwiches().isEmpty()){
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("       You need to order a Sandwich first to get a receipt. ");
                        System.out.println("------------------------------------------------------------------");
                    }else{
                        checkout.printReceipt(order);
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("                   Your Receipt is created.");
                        System.out.println("------------------------------------------------------------------");
                    }
                    break;
                case "cancel order":
                    System.out.println("---------------------------------------------------");
                    System.out.println("            Your order is canceled.");
                    System.out.println("---------------------------------------------------");
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
                    break;
            }
        } while (!orderChoice.equalsIgnoreCase("cancel order"));
    }
}