package collections.training.main;

import java.util.Scanner;

public class CourseMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManagement cm = new CourseManagement();
        short choice = 0;

        do {
            System.out.println("1. Create a course");
            System.out.println("2. List all courses");
            System.out.println("2. Search courses by attribute");
            System.out.println("3. Display courses by flag");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = Short.parseShort(sc.nextLine());

            switch (choice) {
                case 1:
                    cm.input();
                    break;
                case 2:
                    cm.listAll();
                    break;
                case 3:
                    cm.search();
                    break;
                case 4:
                    cm.displayByFlag();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}
