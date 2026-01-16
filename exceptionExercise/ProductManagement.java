package exceptionHandling.exceptionExercise;

import java.util.Scanner;

public class ProductManagement {
    private Product[] products =  new Product[10];
    private int productCount = 0;
    private final static Scanner sc  = new Scanner(System.in);

    public void addProduct(Product product) throws IllegalArgumentException {
        if(productCount >=10){
            throw new IllegalArgumentException("Maximum capacity reached.");
        }

        for(int i=0;i<productCount;i++){
            if(products[i].getProductID()==product.getProductID()){
                throw new IllegalArgumentException("Product with ID " + product.getProductID() + " already exists.");
            }
        }

        products[productCount] = product;
        productCount++;
    }

    public void addProductMenu() {
        try {
            int productID = Inputter.getPositiveInt(sc, "Enter product ID: ");

            String name = Inputter.getNonEmptyString(sc, "Enter product name: ");

            double price = Inputter.getPositiveDouble(sc, "Enter product price: ");

            int quantity = Inputter.getPositiveInt(sc, "Enter product quantity in stock: ");

            Product product = new Product(productID, name, price, quantity);
            addProduct(product);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Product getProductByID(int productID) throws ProductNotFoundException{
        for(int i=0;i<productCount;i++){
            if(products[i].getProductID()==productID){
                return products[i];
            }
        }
        throw new ProductNotFoundException("Product with ID " + productID + " not found.");
    }

    public void getProductByIDMenu() {
        try {
            int productID = Inputter.getPositiveInt(sc, "Enter product ID: ");

            Product product = getProductByID(productID);
            System.out.println("Product data:");
            product.displayProductInfo();

        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateProductQuantity(int productID, int newQuantity) throws ProductNotFoundException{
        Product productFound =  getProductByID(productID);
        productFound.setQuantityInStock(newQuantity);
    }

    public void updateQuantityMenu() {
        try {
            int productID = Inputter.getPositiveInt(sc, "Enter product ID: ");

            Product product = getProductByID(productID);
            System.out.println("Product's current data:");
            product.displayProductInfo();

            int newQuantity = Inputter.getPositiveInt(sc, "Enter product quantity in stock: ");

            updateProductQuantity(productID, newQuantity);

        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
