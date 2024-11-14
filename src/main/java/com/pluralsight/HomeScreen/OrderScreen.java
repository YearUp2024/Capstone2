package com.pluralsight.HomeScreen;

import com.pluralsight.BusinessEntities.SaveOrder;
import com.pluralsight.Console;
import com.pluralsight.BusinessEntities.Sandwich;
import com.pluralsight.OrderScreen.*;
import com.pluralsight.Toppings.ToppingsOptions;
import java.util.List;


public class OrderScreen {
    SandwichInterface sandwichInterface = new SandwichInterface();
    ToppingsOptions toppingsOptions = new ToppingsOptions();
    DrinksInterface drinksInterface = new DrinksInterface();
    SaveOrder saveOrder = new SaveOrder();
    Order order = new Order();

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
                    Drink drink = drinksInterface.orderDrinks();
                    order.addDrink(drink);
                    System.out.println();
                    break;
                case "chips":
                    System.out.println("Add Chips");
                    System.out.println();
                    break;
                case "checkout":
                    boolean wantsToSaveOrder = Console.PromptForYesNo("Do you want to save this order: ");
                    String saveOrderMessage = saveOrder.saveOrder(wantsToSaveOrder, order);
                    System.out.println(saveOrderMessage);
                    break;
                case "cancel order":
                    System.out.println("Your order is canceled.");
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
                    break;
            }
        } while (!orderChoice.equalsIgnoreCase("cancel order"));
    }
}