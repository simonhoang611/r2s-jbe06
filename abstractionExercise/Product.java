package abstraction.abstractionExercise;

import java.util.Scanner;

public abstract class Product {
    protected int id;
    protected String name;
    protected float price;

    public Product(){}

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void input(Scanner sc, Product[] existingProducts, int numOfProducts){
        while(true) {
            int id = InputValidator.getPositiveInt(sc, "Enter ID: ");
            if(!isIdExists(id, existingProducts, numOfProducts)) {
                setId(id);
                break;
            }
            System.out.println("ID already exists! Please enter a different ID.");
        }
        setName(InputValidator.getNonEmptyString(sc, "Enter Name: "));
        setPrice(InputValidator.getPositiveFloat(sc, "Enter price: "));
        inputSpecificFields(sc);
    }

    private boolean isIdExists(int id, Product[] products, int numOfProducts) {
        for(int i = 0; i < numOfProducts; i++) {
            if(products[i] != null && products[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Template method pattern - cho phép subclass override
    protected abstract void inputSpecificFields(Scanner sc);

    // Template method cho việc update các field đặc thù
    public abstract void updateSpecificFields(Scanner sc);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("ID must be positive!");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if(price <= 0){
            throw new IllegalArgumentException("Price must be positive.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + "; Name: " + name + "; Price: " + price;
    }
}