package com.pluralsight.HomeScreen;

import com.pluralsight.Console;

public class UserInterface {
    OrderScreen orderScreen = new OrderScreen();
    public void userChoice(){
        int choice;
        do{
            System.out.println("Please Choose from he options: ");
            System.out.println("[1] New Order");
            System.out.println("[2] Exit");

            choice = Console.PromptForInt("Please enter your choice: ");
            System.out.println();

            switch(choice){
                case 1:
                    orderScreen.userOrder();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Exit");
                    break;
            }
        }while(choice != 2);
    }
}
