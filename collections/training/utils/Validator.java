package collections.training.utils;

import collections.training.entities.Course;
import java.util.HashMap;
import java.util.Scanner;

public class Validator {
    private final static Scanner sc = new Scanner(System.in);

    public Validator() {
    }

    public static void printTableHeader() {
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-30s | %-10s | %-10s | %-15s \n",
                "Code", "Name", "Status", "Duration", "Flag");
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    public static void printTableFooter() {
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    public static String getString(String mess){
        System.out.print(mess);
        return sc.nextLine().trim();
    }

    public static short getShort(String mess) {
        short result = 0;
        while (true) {
            String temp = getString(mess);
            if (Acceptable.isValid(temp, Acceptable.SHORT_VALID)) {
                result = Short.parseShort(temp);
                return result;
            }
            System.out.println("Cannot be empty and must be a positive number!.");
        }
    }

    public static String readNonEmpty(String mess, String errorMsg) {
        String value;
        while (true) {
            value = getString(mess);

            if (!value.isEmpty()){
                return value.trim();
            }
            System.out.println(errorMsg);
        }
    }

    public static String inputAndLoop(String mess, String pattern, String errorMsg){
        String result;
        boolean isInvalid = false;

        do {
            result = getString(mess);
            isInvalid = !Acceptable.isValid(result, pattern);
            if(isInvalid){
                System.out.println(errorMsg);
            }
        } while (isInvalid);
        return result;
    }

    public static String validateCode(HashMap<String, Course> courses) {
        String code;
        boolean isDuplicate;
        do {
            code = inputAndLoop("Enter code: ", Acceptable.CODE_VALID, "Code must follow the format RAxxx !").toUpperCase();
            isDuplicate = courses.containsKey(code);
            if (isDuplicate) {
                System.out.println("Code already exists");
            }
        } while (isDuplicate);
        return code;
    }

    public static boolean validateStatus(){
        String result = inputAndLoop("Enter status(true/false): ",Acceptable.STATUS_VALID, "Status must be 'true' or 'false'");
        boolean status = Boolean.parseBoolean(result);
        return status;
    }

    public static short validateDuration(){
        String input = inputAndLoop("Enter duration: ", Acceptable.SHORT_VALID, "Duration must be a positive integer.");
        short duration = Short.parseShort(input);
        return duration;
    }

    public static String validateFlag(){
        String flag = inputAndLoop("Enter flag: ", Acceptable.FLAG_VALID, "Flag must be 'optional' or 'prerequisite' or 'n/a'.");
        return flag;
    }

}
