package accessModifiers_trainee;

public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;

    public Trainee(String id, String name, String gender, byte age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id==null || id.trim().isEmpty()){
            System.out.println("Trainee id cannot be empty");
            return;
        }
        this.id = id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            System.out.println("Trainee name cannot be empty");
            return;
        }
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender==null || !gender.equalsIgnoreCase("male")||!gender.equalsIgnoreCase("female")){
            System.out.println("Trainee gender must be male/female");
            return;
        }
        this.gender = gender;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if(age< 6){
            System.out.println("Trainee age cannot be less than 6");
            return;
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-18s | %-6s | %3d", id, name, gender, age);
    }
}
