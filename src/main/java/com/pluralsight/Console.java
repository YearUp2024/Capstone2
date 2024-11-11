package com.pluralsight;

import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    public static String PromptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static String PromptForString() {
        return scanner.nextLine();
    }

    public static boolean PromptForYesNo(String prompt) {
        String userinput;
        do{
            System.out.print(prompt + " ( Y for Yes, N for No )? ");
            userinput = scanner.nextLine();
        }while(!userinput.equalsIgnoreCase("Y") &&
                !userinput.equalsIgnoreCase("Yes") &&
                !userinput.equalsIgnoreCase("N") &&
                !userinput.equalsIgnoreCase("No"));

        return (userinput.equalsIgnoreCase("Y") || userinput.equalsIgnoreCase("YES"));
    }

    public static short PromptForShort(String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine();
        short userinput = Short.parseShort(value);
        return userinput;
    }

    public static int PromptForInt(String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine();
        int userinput = Integer.parseInt(value);
        return userinput;
    }

    public static int PromptForInt() {
        String value = scanner.nextLine();
        int userinput = Integer.parseInt(value);
        return userinput;
    }


    public static double PromptForDouble(String prompt) {
        System.out.print(prompt);
        String userInputs = scanner.nextLine();
        double userinput = Double.parseDouble(userInputs);
        return userinput;
    }

    public static byte PromptForByte(String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine();
        byte userinput = Byte.parseByte(value);
        return userinput;
    }

    public static byte PromptForByte() {
        String value = scanner.nextLine();
        byte userinput = Byte.parseByte(value);
        return userinput;
    }

    public static float PromptForFloat(String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine();
        float userinput = Float.parseFloat(value);
        return userinput;
    }
}