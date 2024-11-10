package com.pluralsight.HomeScreen;

import com.pluralsight.Console;
import com.pluralsight.OrderScreen.SandwichInterface;
import com.pluralsight.Toppings.ToppingsOptions;
import java.util.List;

public class OrderScreen {
    SandwichInterface sandwichInterface = new SandwichInterface();
    ToppingsOptions toppingsOptions = new ToppingsOptions();

    public void userOrder() {
        List<String> menuOptions = toppingsOptions.mainMenue();

        String order;
        do {
            System.out.println("Please select from options: ");
            for(String option : menuOptions){
                System.out.println(option);
            }
            order = Console.PromptForString("Enter your choice: ").toLowerCase();
            System.out.println();

            if (menuOptions.contains(order)){
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
            }
        } while (!order.equalsIgnoreCase("cancel order"));
    }
}
