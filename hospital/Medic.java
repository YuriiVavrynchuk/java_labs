package hospital;

public class Medic {
    private String name;
    private int age;
    private Gender gender;
    private int experience;
    private Department department;
    protected String university;
    protected String school;

    static public int numberOfWorkers = 9000;

    public Medic(String name, int age, Gender gender, int experience, Department department, String university, String school) {
        this.resetValues(name, age, gender, experience, department, university, school);
    }

    public Medic(){
        this(null, 0, null, 0, null, null, null);
    }

    public Medic(String name, int age, Gender gender, int experience) {
        this(name, age, gender, experience, null, null, null);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public static void printNumberOfWorkers() {
        System.out.println(numberOfWorkers);
    }

    public void printFieldNumberOfWorkers() {
        System.out.println(numberOfWorkers);
    }

    @Override
    public String toString() {
        return  " name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", gender='" + getGender() + "'" +
                ", experience='" + getExperience() + "'" +
                ", department='" + getDepartment() + "'" +
                ", school='" + getSchool();
    }


    public void resetValues(String name, int age, Gender gender, int experience, Department department, String university, String school) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.experience = experience;
        this.department = department;
        this.university = university;
        this.school = school;
    }


}
