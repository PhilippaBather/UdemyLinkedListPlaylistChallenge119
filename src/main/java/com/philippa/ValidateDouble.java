package com.philippa;

import java.util.Scanner;

/**
 * Class contains user input validation methods.
 */
public class ValidateDouble {

    // instance fields
    private static final Scanner scanner = new Scanner(System.in);

    public static double validateDouble() {
        boolean isValid = false;
        double num = 0.0;

        do {
            String input = scanner.nextLine();
            try {
                num = Double.parseDouble(input);
                return num;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input.  Please enter duration: ");
            }

        } while (!isValid);

        return num;
    }
}
