import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Scanner;

public class Backpack {
    static ArrayList<Course> allCourses = new ArrayList<>();

    public static User enterBackpack(int option) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1. Enter as instructor
                2. Enter as student
                3. Exit""");
        switch (option) {
            case 1 -> {
                System.out.println("Instructors:");
                Instructor.printAll();
            }
            case 2 -> {
                System.out.println("Student");
                Student.printAll();
            }
            case 3 -> {
                System.out.println("Exit");
                return null;
            }
            default ->{
                System.out.println("Not a valid option");
            }
        }

        System.out.print("Choose id: ");
        int id = Integer.parseInt(scanner.next());
        User person;
        if ( option == 1){
            person = Instructor.search(id);
        }else {
            person = Student.search(id);
        }
        return person;
	}
}
