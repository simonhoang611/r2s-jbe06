package inheritance.inheritance_items;

import java.util.Scanner;
public class AntiqueShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemList itemList = new ItemList();
        int choice = 0;

        do{
            System.out.println("1. Add new vase");
            System.out.println("2. Add a new statue");
            System.out.println("3. Add a new painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find the items by the creator");
            System.out.println("6. Display items by type");
            System.out.println("7. Display the list of vase items");
            System.out.println("0. Exit");
            try{
                System.out.print("Input your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
            }catch(NumberFormatException e1){
                System.out.println("Invalid choice. Try again!");
            }

            switch (choice) {
                case 1:
                    Item vase = new Vase();
                    vase.input();
                    if(itemList.addItem(vase)){
                        System.out.println("Vase added");
                    }else{
                        System.out.println("Vase added unsuccessfully!");
                    }
                    break;
                case 2:
                    Item statue = new Statue();
                    statue.input();
                    if(itemList.addItem(statue)){
                        System.out.println("Statue added");
                    }else{
                        System.out.println("Statue added unsuccessfully!");
                    }
                    break;
                case 3:
                    Item painting = new Painting();
                    painting.input();
                    if(itemList.addItem(painting)){
                        System.out.println("Painting added");
                    }else{
                        System.out.println("Painting added unsuccessfully!");
                    }
                    break;
                case 4:
                    itemList.displayAll();
                    break;
                case 5:
                    String creator;
                    if(itemList.getNumItem() == 0){
                        System.out.println("The list is empty.");
                    }else{
                        System.out.print("Enter the name of the creator: ");
                        creator = sc.nextLine().trim();
                        if(creator != null){
                            System.out.println("Item found: ");
                            itemList.findItem(creator);
                        }else{
                            System.out.println("No item found with that creator name!");
                        }
                        break;
                    }
                case 6:
                    String type;
                    if(itemList.getNumItem() == 0){
                        System.out.println("The list is empty.");
                    }else{
                        System.out.print("Enter the type of the item you want to display(Vase/Painting/Statue): ");
                        type = sc.nextLine().trim();
                        if(type != null){
                            System.out.println("Item(s) found: ");
                            itemList.displayItemsByType(type);
                        }else{
                            System.out.println("No item found with that type!");
                        }
                        break;
                    }
                case 7:
                    itemList.displayVases();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }while(choice != 0);
        sc.close();
    }
}