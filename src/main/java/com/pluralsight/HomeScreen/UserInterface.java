package com.pluralsight.HomeScreen;

import com.pluralsight.Console;

public class UserInterface {
    OrderScreen orderScreen = new OrderScreen();
    public void userChoice(){
        int choice = 0;
        do{
            try{
                System.out.println("Please Choose from the options: ");
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
            }catch(Exception e){
                System.out.println();
            }
        }while(choice != 2);
    }
}
