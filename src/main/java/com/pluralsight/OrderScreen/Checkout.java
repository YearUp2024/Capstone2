package com.pluralsight.OrderScreen;

import com.pluralsight.BusinessEntities.Sandwich;
import com.pluralsight.Console;
import java.io.FileWriter;
import java.util.List;

public class Checkout {
    public String saveOrder(boolean wantsToSaveOrder, Sandwich sandwich, Drink drink) {
        if (wantsToSaveOrder) {
            try (FileWriter fileWriter = new FileWriter("saveOrder.txt", true)) {
                String customerName = Console.PromptForString("What is your name: ");

                fileWriter.write(customerName + "|");
                fileWriter.write(sandwich.getSize() + "|");
                fileWriter.write(sandwich.getBreadType() + "|");
                fileWriter.write(sandwich.isToasted() ? "Yes" : "No");
                fileWriter.write("|");
                fileWriter.write(formatToppings(sandwich.getRegularToppings()) + "|");
                fileWriter.write(formatToppings(sandwich.getMeatToppings()) + "|");
                fileWriter.write(formatToppings(sandwich.getCheeseToppings()) + "|");
                fileWriter.write(String.valueOf(sandwich.getPrice()) + "|");
                fileWriter.write(drink.getName() + "|");
                fileWriter.write(drink.getSize() + "|");
                fileWriter.write(drink.getPrice() + "\n");
                return "Your order was saved successfully!";
            } catch (Exception e) {
                return "An error occurred while saving the order.";
            }
        } else {
            return "Order not saved.";
        }
    }

    private String formatToppings(List<String> toppings) {
        if (toppings.isEmpty()) {
            return "None";
        }
        return String.join(", ", toppings);
    }
}