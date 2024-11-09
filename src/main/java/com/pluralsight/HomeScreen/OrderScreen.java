package com.pluralsight.HomeScreen;

import com.pluralsight.Console;
import com.pluralsight.OrderScreen.SandwichInterface;
import com.pluralsight.Toppings.TopingsOptions;
import java.util.Set;

public class OrderScreen {
    SandwichInterface sandwichInterface = new SandwichInterface();
    TopingsOptions topingsOptions = new TopingsOptions();

    public void userOrder(){
        System.out.println("Please select from options: ");
        Set<String> menuOptions = topingsOptions.mainMenue();

        String order;
        do{
            order = Console.PromptForString("Enter your choice: ").toLowerCase();

            if(!menuOptions.contains(order)){
                System.out.println("\nPlease Choose from the options.");
                topingsOptions.mainMenue();
            }else if(menuOptions.contains(order)){
                switch(order){
                    case "sandwich":
                        System.out.println();
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
                    case "Cancel Order":
                        System.out.println("Your order is Called");
                        break;
                    default:
                        System.out.println("Your choice is incorrect.");
                        break;
                }
            }
        }while(!order.equalsIgnoreCase("cancel order"));
    }
}
