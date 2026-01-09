package accessModifiers_trainee;

import java.util.Scanner;

public class TraineeForm {
    private Scanner scanner;

    public TraineeForm(Scanner scanner) {};

    public String getID(){
        String id;
        System.out.println("Enter Trainee's ID: ");
        id = scanner.nextLine();
        return id;
    };

    public String readNonEmpty(String line){
        while(true){
            System.out.println(line);
            String value = scanner.nextLine();
            if(value.isEmpty()){
                System.out.println("Value cannot be empty!");
            }else{
                return value;
            }
        }
    }

    public String readGender(String line){
        while(true){
            System.out.println(line);
            String gender = scanner.nextLine().trim();
            if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female")){
                return gender;
            }else{
                System.out.println("Gender must be male/female");
            }
        }
    }

    public byte readAge(String prompt){
        while(true){
            try{
                System.out.println(prompt);
                String line = scanner.nextLine().trim();
                byte age =  Byte.parseByte(line);

                if(age<6){
                    System.out.println("Trainee age cannot be less than 6");
                }else{
                    return age;
                }
            }catch(NumberFormatException e){
                System.out.println("Age must be an byte value.");
            }
        }
    }

    public Trainee getTrainee(){
        String name = readNonEmpty("Enter Trainee's Name: ");
        String gender = readGender("Enter Trainee's Gender: ");
        byte age = readAge("Enter Trainee's Age: ");
        return new Trainee("", name,gender,age);
    }
}
