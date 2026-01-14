package abstraction.abstractionExercise;


import java.util.Scanner;

public class Program {
    private Product[] products;
    private byte numOfProduct;
    private final int MAX = 100;
    static Scanner sc = new Scanner(System.in);

    public Program() {
        products = new Product[MAX];
        numOfProduct = 0;
    }

    public int getNumOfProduct() {
        return numOfProduct;
    }

    public static void main(String[] args) {
        Program program = new Program();
        int choice;
        do {
            System.out.println("1. Add product");
            System.out.println("2. Display products");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("5. Find product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    if(program.addProduct()) {
                        System.out.println("Product added successfully!");
                    } else {
                        System.out.println("Failed to add product!");
                    }
                    break;
                case 2:
                    program.displayProducts();
                    break;
                case 3:
                    int updateId = InputValidator.getPositiveInt(sc, "Enter product ID to update: ");
                    if(program.updateProduct(updateId)) {
                        System.out.println("Product updated successfully!");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    int deleteId = InputValidator.getPositiveInt(sc, "Enter id to delete: ");
                    program.deleteProduct(deleteId);
                    break;
                case 5:
                    int searchId = InputValidator.getPositiveInt(sc, "Enter product ID to search: ");
                    Product foundProduct = program.findProductByID(searchId);
                    if(foundProduct != null) {
                        System.out.println("Found product: " + foundProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }

    private boolean addProduct() {
        if(numOfProduct >= MAX) {
            System.out.println("Product list is full!");
            return false;
        }

        System.out.println("\nSelect product type:");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");

        int type = InputValidator.getIntInRange(sc, "Enter product type: ", 1, 2);

        try {
            Product product = createProduct(type);

            products[numOfProduct++] = product;
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    private Product createProduct(int type) {
        Product product;

        if(type == 1) {
            product = new Electronics();
        } else {
            product = new Clothing();
        }

        product.input(sc, products, numOfProduct);
        return product;
    }

    public void displayProducts(){
        for(int i = 0; i<numOfProduct;i++){
            System.out.println(products[i].toString());
        }
    }

    private boolean updateProduct(int id) {
        Product product = findProductByID(id);

        if(product == null) {
            return false;
        }

        System.out.println("Found product: " + product);
        System.out.println("\nEnter new information:");

        try {
            String name = InputValidator.getNonEmptyString(sc, "Enter new name: ");
            float price = InputValidator.getPositiveFloat(sc, "Enter new price: ");

            product.setName(name);
            product.setPrice(price);
            product.updateSpecificFields(sc);

            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].id == id) {
                for (int j = i; j < numOfProduct - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[numOfProduct - 1] = null;
                numOfProduct--;
                System.out.println("Product deleted.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private Product findProductByID(int id) {
        for(int i = 0; i < numOfProduct; i++) {
            if(products[i]!=null && products[i].id == id) {
                return products[i];
            }
        }
        return null;
    }
}
