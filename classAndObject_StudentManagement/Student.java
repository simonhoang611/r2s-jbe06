package classAndObject_StudentManagement;

import java.util.Scanner;

public class Student {
    int id;
    String name;
    int age;
    String address;
    String gender;
    String email;

    public Student(int id, String name, int age, String address, String gender, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.email = email;
    }
}
