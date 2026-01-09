package accessModifiers_trainee;

import java.util.Scanner;

public class TrainingManagement {
    private TraineeForm traineeForm;
    private Scanner scanner;
    private Trainee[] listOfTrainees =  new Trainee[100];
    private byte count = 0;

    public TrainingManagement(TraineeForm traineeForm, Scanner scanner) {
        this.traineeForm = new TraineeForm(scanner);
        this.scanner = new Scanner(System.in);
    }

    private void menuDisplay(){
        while(true){
            System.out.println("======= Trainee Menu =======");
            System.out.println("1. Add Trainee");
            System.out.println("2. Display All Trainee");
            System.out.println("3. Find Trainee By ID");
            System.out.println("4. Find Trainee By Name");
            System.out.println("5. Update Trainee By ID");
            System.out.println("0. Quit");
            System.out.print("Your choice: ");
            byte choice = Byte.parseByte(scanner.nextLine());

            switch(choice){
                case 1:
                    addTrainee();
                    break;
                case 2:
                    displayAllTrainee();
                    break;
                case 3:
                    String idToFind;

                    System.out.println("Enter Trainee ID to find: ");
                    idToFind =  scanner.nextLine().trim();
                    Trainee traineeFound = findTraineeByID(idToFind);
                    if(traineeFound == null){
                        System.out.println("Trainee not found");
                    }else {
                        System.out.println(header());
                        System.out.println(traineeFound);
                    }
                case 4:
                    String name;

                    System.out.println("Enter Trainee Name to find: ");
                    name =  scanner.nextLine().trim();
                    Trainee[] traineesFound = findTraineeByName(name);
                    if(traineesFound.length == 0){
                        System.out.println("Trainee not found");
                    }else {
                        System.out.println(header());
                        for (Trainee trainee : traineesFound) {
                            System.out.println(trainee);
                        }
                    }
                case 5:
                    String idToUpdate;

                    System.out.println("Enter Trainee ID to update: ");
                    idToUpdate = scanner.nextLine().trim();

                    Trainee traineeUpdated = traineeForm.getTrainee();
                    updateTrainee(idToUpdate, traineeUpdated);
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private byte indexOfID(String id){
        for(byte i=0;i<count;i++){
            if(listOfTrainees[i].getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    private void addTrainee(){
        String id;
        String name;
        String gender;
        byte age;

        if(count >= listOfTrainees.length){
            System.out.println("The list is full.");
            return;
        }

        while(true){
            id= traineeForm.getID();
            if(indexOfID(id)==-1){
                break;
            }else{
                System.out.println("Id already exists.");
            }
        }

        Trainee trainee = traineeForm.getTrainee();
        trainee.setId(id);
        listOfTrainees[count] = trainee;
        count++;

        System.out.println("New Trainee added.");
    }

    private void displayAllTrainee(){
        if(count == 0){
            System.out.println("There are no students");
            return;
        }

        for(int i=0;i<count;i++){
            System.out.println(listOfTrainees[i]);
        }
    }

    private Trainee findTraineeByID(String id){
        byte index = indexOfID(id);
        if(index == -1){
            return null;
        }else{
            return listOfTrainees[index];
        }
    }

    private Trainee[] findTraineeByName(String name){
        String key = name.toLowerCase();
        Trainee[] traineesFound = new Trainee[count];
        byte traineesFoundCount = 0;

        for(int i=0;i<count;i++){
            if(listOfTrainees[i].getName().toLowerCase().contains(key)){
                traineesFound[traineesFoundCount] = listOfTrainees[i];
                traineesFoundCount++;
            }
        }
        return traineesFound;
    }

    private void updateTrainee(String id, Trainee newTrainee){
        byte index = indexOfID(id);
        if(index == -1){
            System.out.println("Trainee not found.");
            return;
        }
        listOfTrainees[index].setName(newTrainee.getName());
        listOfTrainees[index].setGender(newTrainee.getGender());
        listOfTrainees[index].setAge(newTrainee.getAge());

        System.out.println("New Trainee updated.");
    }

    private String header() {
        return String.format("%-8s | %-18s | %-6s | %3s", "ID", "NAME", "SEX", "AGE");
    }
}
