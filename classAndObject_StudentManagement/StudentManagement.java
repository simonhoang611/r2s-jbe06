package classAndObject_StudentManagement;

import java.util.Scanner;

public class StudentManagement {
    Student[] students = new Student[100];
    Scanner sc = new Scanner(System.in);
    int count=0;

    Student findStudentByID(int id){
        for(int i=0;i<count;i++){
            if(students[i] != null && students[i].id==id){
                return students[i];
            }
        }
        return null;
    }

    void createStudent(){
        int id;
        String name;
        int age;
        String address;
        String gender;
        String email;

        if(count>=100){
            System.out.println("The list is full");
            return;
        }

        while(true) {
            System.out.print("Enter student ID: ");
            id = Integer.parseInt(sc.nextLine());
            if(findStudentByID(id)!=null){
                System.out.println("Student ID is already in use");
            }else {
                break;
            }
        }

        while(true){
            System.out.print("Enter student name: ");
            name = sc.nextLine();
            if(name.isEmpty()){
                System.out.println("Student name cannot be empty");
            }else{
                break;
            }
        }

        while(true){
            System.out.print("Enter student age: ");
            age = Integer.parseInt(sc.nextLine());
            if(age<18){
                System.out.println("Student age cannot be less than 18");
            }else{
                break;
            }
        }

        System.out.print("Enter student address: ");
        address = sc.nextLine();

        while(true){
            System.out.print("Enter student gender: ");
            gender = sc.nextLine();
            if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")){
                break;
            }else{
                System.out.println("Invalid gender");
            }
        }

        System.out.print("Enter student email: ");
        email = sc.nextLine();

        students[count]=new Student(id, name, age, address, gender, email);
        count++;
    }

    void listALl(){
        for(int i=0;i<count;i++){
            System.out.println("Student "+(i+1)+" data");
            System.out.println("ID: "+students[i].id);
            System.out.println("Name: "+students[i].name);
            System.out.println("Age: "+students[i].age);
            System.out.println("Address: "+students[i].address);
            System.out.println("Gender: "+students[i].gender);
            System.out.println("Email: "+students[i].email);
            System.out.println();
        }
    }

    void findByID(){
        Student student;
        int id;
        System.out.print("Enter student ID: ");
        id = Integer.parseInt(sc.nextLine());
        student = findStudentByID(id);
        if (student != null) {
            System.out.println("\nStudent found:");
            System.out.println("ID: " + student.id);
            System.out.println("Name: " + student.name);
            System.out.println("Age: " + student.age);
            System.out.println("Address: " + student.address);
            System.out.println("Gender: " + student.gender);
            System.out.println("Email: " + student.email);
            System.out.println();
        } else {
            System.out.println("Student with ID " + id + " not found.\n");
        }
    }

    void updateStudent(){
        Student student;
        int id;
        String newName;
        int newAge;
        String newAddress;
        String newGender;
        String newEmail;

        System.out.print("Enter student ID: ");
        id = Integer.parseInt(sc.nextLine());
        student = findStudentByID(id);
        if(student == null){
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        while(true){
            System.out.print("Enter new name: ");
            newName = sc.nextLine();
            if(newName.isEmpty()){
                System.out.println("Student name cannot be empty");
            }else{
                student.name = newName;
                break;
            }
        }

        while(true){
            System.out.print("Enter new age: ");
            newAge = Integer.parseInt(sc.nextLine());
            if(newAge<18){
                System.out.println("Student age cannot be less than 18");
            }else{
                student.age = newAge;
                break;
            }
        }

        System.out.print("Enter new address: ");
        newAddress = sc.nextLine();
        student.address = newAddress;

        while(true){
            System.out.print("Enter new gender: ");
            newGender = sc.nextLine();
            if(newGender.equalsIgnoreCase("male") || newGender.equalsIgnoreCase("female")){
                student.gender = newGender;
                break;
            }else{
                System.out.println("Invalid gender");
            }
        }

        System.out.print("Enter new email: ");
        newEmail = sc.nextLine();
        student.email = newEmail;
    }
}
