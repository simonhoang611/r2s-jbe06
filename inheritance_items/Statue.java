package inheritance.inheritance_items;

import java.util.Scanner;
public class Statue extends Item{
    private int weight;
    private String colour;

    public Statue(){
    }

    public Statue(String id, int value, String creator, int weight, String colour) {
        super(id, value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Enter weight: ");
                setWeight(Integer.parseInt(sc.nextLine()));
                break;
            }catch(NumberFormatException e){
                System.out.println("Invalid input! Please enter a valid number.");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while(true){
            try{
                System.out.print("Enter colour: ");
                setColour(sc.nextLine());
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void setWeight(int weight){
        if(weight <= 0){
            throw new IllegalArgumentException("Weight must be positive!");
        }
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public void setColour(String colour){
        if(colour == null || colour.trim().isEmpty()){
            throw new IllegalArgumentException("Colour cannot be empty!");
        }
        this.colour = colour;
    }

    public String getColour(){
        return colour;
    }

    @Override
    public String toString() {
        return super.toString()+"; Weight: "+weight+"; Colour: "+colour;
    }

}