package exceptionHandling.exceptionExercise;

import java.util.Scanner;

public class Program {
    private static final Scanner sc=new Scanner(System.in);
    private static final ProductManagement pm = new ProductManagement();

    public static void main(String[] args) {
        int choice =0;
        do{
            System.out.println("1. Add product");
            System.out.println("2. Retrieve product by ID");
            System.out.println("3. Update product quantity");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice= Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    pm.addProductMenu();
                    break;
                case 2:
                    pm.getProductByIDMenu();
                    break;
                case 3:
                    pm.updateQuantityMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
        sc.close();
    }

}
