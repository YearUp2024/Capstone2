package com.pluralsight.OrderScreen;

import com.pluralsight.Console;
import com.pluralsight.Toppings.TopingsOptions;

public class SandwichInterface {
    public void orderSandwich(){
        System.out.println("What size Sandwich do you want?");
        TopingsOptions topingsOptions = new TopingsOptions();
        topingsOptions.sandwichSizeType();
        int sandWichSize = Console.PromptForInt("Enter your choice: ");
    }
}
