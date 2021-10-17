import java.util.ArrayList;

public class Student implements User {
    static ArrayList<Student> allStudents = new ArrayList<>();
    String name;
    int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static Student search(int id){
        for ( Student s: allStudents){
            if (s.id == id){
                return s;
            }
        }
        System.out.println("Student not found");
        return null;
    }

    @Override
    public void perform(int option){


    }

    @Override
    public void viewLectureMaterial() {

    }

    @Override
    public void viewAssessment() {

    }

    @Override
    public void viewComments() {

    }

    @Override
    public void addComments() {

    }

    @Override
    public void logout() {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void menuForUser() {
        System.out.println("Welcome " + this.name);
        System.out.println("""
                1. View lecture materials
                2. View assessments
                3. Submit assessment
                4. View grades
                5. View comments
                6. Add comments
                7. Logout""");
    }

    public static void printAll(){
        for ( Student k: allStudents){
            System.out.println(k);
        }
    }


    @Override
    public String toString(){
        return this.id + " - " + this.name;
    }
}
