package com.pluralsight.Interfaces;

import com.pluralsight.Console;
import com.pluralsight.HomeScreen.OrderScreen;

public class UserInterface {
    OrderScreen orderScreen = new OrderScreen();

    /**
     * This displays all the choices the users have.
     */
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
                        System.out.println("---------------------------------------------------");
                        System.out.println("               Buy Come Again Soon!!!");
                        System.out.println("---------------------------------------------------");
                        break;
                }
            }catch(Exception e){
                System.out.println();
            }
        }while(choice != 2);
    }
}
