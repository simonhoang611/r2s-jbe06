package classAndObject_StudentManagement;

import java.util.Scanner;

public class Menu {
    static Student[] students = new Student[100];
    static StudentManagement sm = new StudentManagement();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;

        do {
            System.out.println("1. Create a student");
            System.out.println("2. Display all");
            System.out.println("3. Find a student by id");
            System.out.println("4. Update a student by id ");
            System.out.println("5. Quit");
            System.out.print("Your choice: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    sm.createStudent();
                    break;
                case 2:
                    sm.listALl();
                    break;
                case 3:
                    sm.findByID();
                    break;
                case 4:
                    sm.updateStudent();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (option != 5);
        sc.close();
    }
}
