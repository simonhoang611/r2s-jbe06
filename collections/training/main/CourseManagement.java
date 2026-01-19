package collections.training.main;

import collections.training.entities.Course;
import collections.training.utils.Acceptable;
import collections.training.utils.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CourseManagement {
    private final HashMap<String, Course> courses= new HashMap<>();
    private int courseCount = 0;
    private final static Scanner sc = new Scanner(System.in);

    public CourseManagement() {
    }

    public void input(){
        String code = Validator.validateCode(courses);
        String name = Validator.readNonEmpty("Enter name: ", "Name cannot be empty");
        boolean status = Validator.validateStatus();
        short duration = Validator.validateDuration();
        String flag = Validator.validateFlag();

        Course course = new Course(code, name, status, duration, flag);
        courses.put(code, course);
    }



    public void search(){
        ArrayList<Course> results = new ArrayList<>();
        if(courses.isEmpty()){
            System.out.println("The list is empty");
            return;
        }

        System.out.println("1. Search by Code");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Status");
        System.out.println("4. Search by Duration");
        System.out.println("5. Search by Flag");
        short choice = Validator.getShort("Choose attribute to search: ");
        switch (choice){
            case 1:
                String code = Validator.readNonEmpty("Enter code: ",  "Code cannot be empty").toUpperCase();
                Course course = courses.get(code);
                if(course != null){
                    results.add(course);
                }
                break;
            case 2:
                String name = Validator.readNonEmpty("Enter name: ", "Name cannot be empty");
                for(Course c : courses.values()){
                    if(c.getName().contains(name)){
                        results.add(c);
                    }
                }
                break;
            case 3:
                boolean status = Validator.validateStatus();
                for (Course c : courses.values()) {
                    if (c.isStatus() == status) {
                        results.add(c);
                    }
                }
                break;
            case 4:
                short duration = Validator.validateDuration();
                for (Course c : courses.values()) {
                    if (c.getDuration() == duration) {
                        results.add(c);
                    }
                }
                break;
            case 5:
                String flag = Validator.validateFlag();
                for (Course c : courses.values()) {
                    if (c.getFlag().equalsIgnoreCase(flag)) {
                        results.add(c);
                    }
                }
                break;
                default:
                    System.out.println("Invalid choice");
                    return;
        }
        if(results.isEmpty()){
            System.out.println("There is no course match what you searched!");
        }else {
            Validator.printTableHeader();
            for (Course c : results) {
                System.out.println(c);
            }
            Validator.printTableFooter();
        }
    }

    public void listAll(){
        if(courses.isEmpty()){
            System.out.println("The list is empty");
            return;
        }

        Validator.printTableHeader();
        for(Course c : courses.values()){
            System.out.println(c);
        }
        Validator.printTableFooter();
    }

    public void displayByFlag(){
        if(courses.isEmpty()){
            System.out.println("The list is empty");
            return;
        }

        ArrayList<Course> coursesFound = new ArrayList<>();
        String flag = Validator.validateFlag();
        for (Course c : courses.values()) {
            if (c.getFlag().equalsIgnoreCase(flag)) {
                coursesFound.add(c);
            }
        }

        if(coursesFound.isEmpty()){
            System.out.println("There is no course match that flag!");
        }else{
            Validator.printTableHeader();
            for (Course c : coursesFound) {
                System.out.println(c);
            }
            Validator.printTableFooter();
        }
    }

}
