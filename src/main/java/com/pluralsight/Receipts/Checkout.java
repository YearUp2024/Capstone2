package com.pluralsight.Receipts;

import com.pluralsight.BusinessEntities.Sandwich;
import com.pluralsight.OrderScreen.Chips;
import com.pluralsight.OrderScreen.Drink;
import com.pluralsight.OrderScreen.Order;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Checkout {
    public void printReceipt(Order order) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = localDateTime.format(dateTimeFormatter);
        String fileName = "receipts/" + timestamp + ".txt";
        double totalCost = 0.0;

        File receiptsFolder = new File("/Users/iftekarhossain/Documents/pluralsight/java-development/Capstones/SwenswitchShop/src/main/java/com/pluralsight/Receipts");
        if (!receiptsFolder.exists()) {
            receiptsFolder.mkdir();
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("             Your Receipt\n");
            fileWriter.write("Date and Time: " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            fileWriter.write("-------------------------------------------------------\n");

            for (Sandwich sandwich : order.getSandwiches()) {
                fileWriter.write("Sandwich: " + sandwich.getName() + "\n");
                fileWriter.write("Size: " + sandwich.getSize() + " inches\n");
                fileWriter.write("Bread Type: " + sandwich.getBreadType() + "\n");
                fileWriter.write("Toasted: " + (sandwich.isToasted() ? "Yes" : "No") + "\n");
                fileWriter.write("Regular Toppings: " + formatToppings(sandwich.getRegularToppings()) + "\n");
                fileWriter.write("Meat Toppings: " + formatToppings(sandwich.getMeatToppings()) + "\n");
                fileWriter.write("Cheese Toppings: " + formatToppings(sandwich.getCheeseToppings()) + "\n");
                fileWriter.write("-------------------------------------------------------\n");
                fileWriter.write("Price: " + sandwich.getPrice() + "\n");
                totalCost += sandwich.getPrice();
                fileWriter.write("-------------------------------------------------------\n\n");
            }

            for (Drink drink : order.getDrinks()) {
                fileWriter.write("Drink: " + drink.getName() + "\n");
                fileWriter.write("Size: " + drink.getSize() + "\n");
                fileWriter.write("-------------------------------------------------------\n");
                fileWriter.write("Price: " + drink.getPrice() + "\n");
                totalCost += drink.getPrice();
                fileWriter.write("-------------------------------------------------------\n\n");
            }

            for (Chips chips : order.getChips()) {
                fileWriter.write("Chips: " + chips.getName() + "\n");
                fileWriter.write("-------------------------------------------------------\n");
                fileWriter.write("Price: " + chips.getPrice() + "\n");
                totalCost += chips.getPrice();
                fileWriter.write("-------------------------------------------------------\n");
            }
            fileWriter.write("Total Cost: " + totalCost + "\n");

            System.out.println("Receipt saved successfully to " + fileName);
        } catch (Exception e) {
            System.out.println("An error occurred while saving the receipt: " + e.getMessage());
        }
    }

    private String formatToppings(List<String> toppings) {
        if (toppings.isEmpty()) {
            return "None";
        }
        return String.join(", ", toppings);
    }
}