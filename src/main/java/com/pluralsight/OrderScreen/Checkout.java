package com.pluralsight.OrderScreen;

import java.io.FileWriter;
import java.util.List;

public class Checkout {
    public String saveOrder(boolean wantsToSaveOrder, AddSandwich sandwich){

        if(wantsToSaveOrder){
            try(FileWriter fileWriter = new FileWriter("saveOrder.txt", true)){
                fileWriter.write(sandwich.getSize() + "|");
                fileWriter.write(sandwich.getBreadType() + "|");
                fileWriter.write(sandwich.isToasted() ? "Yes" : "No");
                fileWriter.write( "|");
                fileWriter.write(formatToppings(sandwich.getRegularToppings()) + "|");
                fileWriter.write(formatToppings(sandwich.getMeatToppings())  + "|");
                fileWriter.write(formatToppings(sandwich.getCheeseToppings())  + "|");
                fileWriter.write(String.valueOf(sandwich.getPrice()) + "\n");
                return "Order save successfully!";
            }catch(Exception e){
                return "An error occurred while saving the order.";
            }
        }else{
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
