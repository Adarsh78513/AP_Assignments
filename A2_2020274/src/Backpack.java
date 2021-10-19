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

        //Getting the proper input
        int id = 0;
        boolean done = false;
        do{
            String temp = Main.scanner.nextLine();
            try {
                id = Integer.parseInt(temp);

                done = true;
            }catch(Exception e){
                System.out.println("\n" + "\"" + temp +"\"" + " Is not a valid input.\n");
                System.out.println("Choose id: ");

            }
        }while(!done);


        User person;
        if ( option == 1){
            person = Instructor.search(id);
        }else {
            person = Student.search(id);
        }

        if ( person != null){
            person.login();
        }
        return person;
	}
}
