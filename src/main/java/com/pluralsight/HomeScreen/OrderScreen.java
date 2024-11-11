package com.pluralsight.HomeScreen;

import com.pluralsight.Console;
import com.pluralsight.OrderScreen.SandwichInterface;
import com.pluralsight.Toppings.ToppingsOptions;
import java.util.List;

public class OrderScreen {
    SandwichInterface sandwichInterface = new SandwichInterface();
    ToppingsOptions toppingsOptions = new ToppingsOptions();

    public void userOrder() {
        List<String> menuOptions;

        String order = "";
        do {
            System.out.println("Please select from options: ");
            menuOptions = toppingsOptions.mainMenue();

            int userChoice = Console.PromptForInt("Enter your choice: ");
            do{
                System.out.println("Please select from options: ");
                menuOptions = toppingsOptions.mainMenue();

                if(userChoice == 1){
                    order = "sandwich";
                }else if(userChoice == 2){
                    order = "drink";
                }else if(userChoice == 3){
                    order = "chips";
                }else if(userChoice == 4){
                    order = "checkout";
                }else if(userChoice == 5){
                    order = "cancel order";
                }
            }while(userChoice != 1 || userChoice != 2 || userChoice != 3 || userChoice != 4 || userChoice != 5);
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
