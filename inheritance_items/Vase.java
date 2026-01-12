package inheritance.inheritance_items;

import java.util.Scanner;
public class Vase extends Item{
    private int height;
    private String material;

    public Vase(){
    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        this.height = height;
        this.material = material;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Enter height: ");
                setHeight(Integer.parseInt(sc.nextLine()));
                break;
            }catch(NumberFormatException e){
                System.out.println("Invalid input! Please enter a valid number.");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while(true){
            try{
                System.out.print("Enter material: ");
                setMaterial(sc.nextLine());
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void setHeight(int height){
        if(height <= 0){
            throw new IllegalArgumentException("Height must be positive!");
        }
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public void setMaterial(String material){
        if(material == null || material.trim().isEmpty()){
            throw new IllegalArgumentException("Material cannot be empty!");
        }
        this.material = material;
    }

    public String getMaterial(){
        return material;
    }

    @Override
    public String toString() {
        return super.toString()+"; Height: "+height+"; Material: "+material;
    }
}