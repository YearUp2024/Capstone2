package com.pluralsight.BusinessEntities;

import com.pluralsight.Console;
import com.pluralsight.OrderScreen.Drink;
import com.pluralsight.OrderScreen.Order;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class SaveOrder {
    public String saveOrder(boolean wantsToSaveOrder, Order order) {
        if (wantsToSaveOrder) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("saveOrdeer.txt", true))) {
                String customerName = Console.PromptForString("What is your name: ");
                bufferedWriter.write(customerName + "\n");

                for (Sandwich sandwich : order.getSandwiches()) {
                    bufferedWriter.write("Sandwich|");
                    bufferedWriter.write(sandwich.getSize() + "|");
                    bufferedWriter.write(sandwich.getBreadType() + "|");
                    bufferedWriter.write(sandwich.isToasted() ? "Yes" : "No");
                    bufferedWriter.write("|");
                    bufferedWriter.write(formatToppings(sandwich.getRegularToppings()) + "|");
                    bufferedWriter.write(formatToppings(sandwich.getMeatToppings()) + "|");
                    bufferedWriter.write(formatToppings(sandwich.getCheeseToppings()) + "|");
                    bufferedWriter.write(String.valueOf(sandwich.getPrice()) + "\n");
                }

                for (Drink drink : order.getDrinks()) {
                    bufferedWriter.write("Drink|");
                    bufferedWriter.write(drink.getName() + "|");
                    bufferedWriter.write(drink.getSize() + "|");
                    bufferedWriter.write(String.valueOf(drink.getPrice()) + "\n");
                }

                return "Your order was saved successfully!";
            } catch (Exception e) {
                return "An error occurred while saving the order.";
            }
        } else {
            return "Order not saved.";
        }
    }

    private String formatToppings(List<String> toppings){
        if(toppings.isEmpty()){
            return "None";
        }
        return String.join(", ", toppings);
    }
}