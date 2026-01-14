package abstraction.abstractionExercise;

import java.util.Scanner;

public class Clothing extends Product {
    private String size;

    public Clothing(){}

    public Clothing(int id, String name, float price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    protected void inputSpecificFields(Scanner sc) {
        setSize(InputValidator.getNonEmptyString(sc, "Enter size: "));
    }

    @Override
    public void updateSpecificFields(Scanner sc) {
        setSize(InputValidator.getNonEmptyString(sc, "Enter new size: "));
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if(size == null || size.trim().isEmpty()){
            throw new IllegalArgumentException("Size cannot be empty");
        }
        this.size = size.trim();
    }

    @Override
    public String toString() {
        return super.toString() + "; Size: " + size;
    }
}
