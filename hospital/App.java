package hospital;

public class App {
    static Medic vasyl = new Medic("Vasyl", 19, Gender.MALE, 1, Department.EAST, "paliteh", "97");
    static Medic ivan = new Medic("Ivan", 30, Gender.MALE, 10);
    static Medic galya = new Medic();
    public static void main(String[] args) {
        ivan.setDepartment(Department.SOUTH);
        ivan.setUniversity("yky");
        ivan.setSchool("81");
        galya.setName("Galya");
        galya.setAge(100);
        galya.setGender(Gender.FEMALE);
        galya.setExperience(80);
        galya.setDepartment(Department.WEST);
        galya.setUniversity("KPI");
        galya.setSchool("bursa");
        System.out.println(vasyl);
        System.out.println(ivan);
        System.out.println(galya);
        Medic.printNumberOfWorkers();
        ivan.printFieldNumberOfWorkers();
    }
}
