import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Scanner;

public class Backpack {
    static ArrayList<Course> allCourses = new ArrayList<>();

    public static User enterBackpack(int option) {
        switch (option) {
            case 1 -> {
                System.out.println("Instructors:");
                Instructor.printAll();
            }
            case 2 -> {
                System.out.println("Student");
                Student.printAll();
            }
            default -> System.out.println("Not a valid option");
        }

        System.out.print("Choose id: ");
        int id = Integer.parseInt(Main.scanner.nextLine());
        User person;
        if ( option == 1){
            person = Instructor.search(id);
        }else {
            person = Student.search(id);
        }
        person.login();
        return person;
	}
}
