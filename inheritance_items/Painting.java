package inheritance.inheritance_items;

import java.util.Scanner;
public class Painting extends Item{
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting(){
    }

    public Painting(String id, int value, String creator, int height, int width, boolean isWatercolour, boolean isFramed) {
        super(id, value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
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
                System.out.print("Enter width: ");
                setWidth(Integer.parseInt(sc.nextLine()));
                break;
            }catch(NumberFormatException e){
                System.out.println("Invalid input! Please enter a valid number.");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try{
                System.out.print("Watercolour (true/false): ");
                isWatercolour = Boolean.parseBoolean(sc.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Invalid input! Please enter true or false.");
            }
        }

        while(true){
            try{
                System.out.print("Framed (true/false): ");
                isFramed = Boolean.parseBoolean(sc.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Invalid input! Please enter true or false.");
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

    public void setWidth(int width){
        if(width <= 0){
            throw new IllegalArgumentException("Width must be positive!");
        }
        this.width = width;
    }

    public int getWidth(){
        return width;
    }

    public void setWatercolour(boolean watercolour){
        isWatercolour = watercolour;
    }

    public boolean isWatercolour(){
        return isWatercolour;
    }

    public void setFramed(boolean framed){
        isFramed = framed;
    }

    public boolean isFramed(){
        return isFramed;
    }

    @Override
    public String toString() {
        return super.toString()+"; Height: "+height+"; Width: "+width+"; Watercolour: "+isWatercolour+"; Framed: "+isFramed;
    }
}