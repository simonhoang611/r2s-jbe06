package abstraction.abstractionExercise;

import java.util.Scanner;

public class InputValidator {

    private InputValidator() {}

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

    public static float getPositiveFloat(Scanner sc, String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                float value = Float.parseFloat(sc.nextLine().trim());
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

    public static int getIntInRange(Scanner sc, String prompt, int min, int max) {
        while(true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(sc.nextLine().trim());
                if(value < min || value > max) {
                    System.out.println("Value must be between " + min + " and " + max);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }
}