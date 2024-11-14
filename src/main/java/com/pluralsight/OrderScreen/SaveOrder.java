package com.pluralsight.OrderScreen;

import com.pluralsight.BusinessEntities.Sandwich;
import com.pluralsight.Console;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class SaveOrder {
    public String saveOrder(boolean wantsToSaveOrder, Sandwich sandwich, Drink drink, Chips chips) {
        if (wantsToSaveOrder) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("saveOrder.txt", true)) ) {
                String customerName = Console.PromptForString("What is your name: ");

                bufferedWriter.write(customerName + "|");
                bufferedWriter.write(sandwich.getSize() + "|");
                bufferedWriter.write(sandwich.getBreadType() + "|");
                bufferedWriter.write(sandwich.isToasted() ? "Yes" : "No");
                bufferedWriter.write("|");
                bufferedWriter.write(formatToppings(sandwich.getRegularToppings()) + "|");
                bufferedWriter.write(formatToppings(sandwich.getMeatToppings()) + "|");
                bufferedWriter.write(formatToppings(sandwich.getCheeseToppings()) + "|");
                bufferedWriter.write(String.valueOf(sandwich.getPrice()) + "|");
                bufferedWriter.write(drink.getName() + "|");
                bufferedWriter.write(drink.getSize() + "|");
                bufferedWriter.write(drink.getPrice() + "|");
                bufferedWriter.write(chips.getName() + "|");
                bufferedWriter.write(chips.getPrice() + "\n");
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