package exceptionHandling.exceptionExercise;

import java.util.Scanner;

public class Inputter {

    private Inputter() {}

    public static int getPositiveInt(Scanner sc, String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(sc.nextLine().trim());
                if(value <= 0) {
                    System.out.println("Value must be positive!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }

    public static double getPositiveDouble(Scanner sc, String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(sc.nextLine().trim());
                if(value <= 0) {
                    System.out.println("Value must be positive!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static String getNonEmptyString(Scanner sc, String prompt) {
        while(true) {
            System.out.print(prompt);
            String value = sc.nextLine().trim();
            if(value.isEmpty()) {
                System.out.println("Input cannot be empty!");
                continue;
            }
            return value;
        }
    }

}
