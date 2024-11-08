package com.pluralsight.HomeScreen;

import com.pluralsight.Console;

public class OrderScreen {
    public void userOrder(){
        int order;

        do{
            System.out.println("Please select from options: ");
            System.out.println("[1] - Add Sandwich");
            System.out.println("[2] - Add Drink");
            System.out.println("[3] - Add Chips");
            System.out.println("[4] - Checkout");
            System.out.println("[5] - Cancel Order");

            order = Console.PromptForInt("Enter your choice: ");
            System.out.println();
            switch(order){
                case 1:
                    System.out.println("Add Sandwich");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Add Drink");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Add Chips");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Checkout");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Your order is Called");
                    break;
            }
        }while(order != 5);
    }
}
