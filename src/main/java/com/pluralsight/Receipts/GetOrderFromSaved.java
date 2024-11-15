package com.pluralsight.Receipts;

import java.io.BufferedReader;
import java.io.FileReader;

public class GetOrderFromSaved {
    private static String fileName = "saveOrder.txt";

    /**
     * ReadFromSaved
     */
    public void readFromSaved(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            boolean firstLine = true;

            while((line = bufferedReader.readLine()) != null){
                if(firstLine){
                    firstLine = false;
                    continue;
                }

                String[] newLine = line.split("\\|");
            }

        }catch(Exception e){
            System.out.println("File could not be read.");
        }
    }

    /**
     * ParseOrderDetails
     */

    /**
     * DisplayOrder
     */

    /**
     * FormatToppings
     */
}