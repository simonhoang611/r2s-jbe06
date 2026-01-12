package inheritance.inheritance_items;

import java.util.Scanner;
public class Item {
    protected String id;
    protected int value;
    protected String creator;

    public Item(){

    }

    public Item(String id, int value, String creator) {
        this.id = id;
        this.value = value;
        this.creator = creator;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getCreator(){
        return creator;
    }

    public void input(){
        Scanner sc= new Scanner(System.in);
        while(true) {
            System.out.print("Enter ID: ");
            id = sc.nextLine();
            if(!id.isEmpty()){
                break;
            }else{
                System.out.println("Must enter ID!");
            }
        }
        while(true){
            try{
                System.out.print("Enter value: ");
                value = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("Invalid value! Please enter a valid number.");
            }
        }
        while(true){
            System.out.print("Enter creator: ");
            creator = sc.nextLine();
            if(!creator.isEmpty()){
                break;
            }else{
                System.out.println("Must enter creator!");
            }
        }
    }

    @Override
    public String toString(){
        return "ID: "+id+"; Value: "+value+"; Creator: "+creator;
    }
}
