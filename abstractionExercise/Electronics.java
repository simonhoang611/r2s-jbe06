package abstraction.abstractionExercise;

import java.util.Scanner;

public class Electronics extends Product {
    private String brand;

    public Electronics(){}

    public Electronics(int id, String name, float price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    protected void inputSpecificFields(Scanner sc) {
        setBrand(InputValidator.getNonEmptyString(sc, "Enter brand: "));
    }

    @Override
    public void updateSpecificFields(Scanner sc) {
        setBrand(InputValidator.getNonEmptyString(sc, "Enter new brand: "));
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand == null || brand.trim().isEmpty()){
            throw new IllegalArgumentException("Brand cannot be empty!");
        }
        this.brand = brand.trim();
    }

    @Override
    public String toString() {
        return super.toString() + "; Brand: " + brand;
    }
}
