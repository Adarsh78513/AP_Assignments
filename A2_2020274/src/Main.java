import java.util.Scanner;

import javax.lang.model.util.ElementKindVisitor14;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //for initialising the backpack with courses, 
        //dummy students and teachers.
        InitialiseBackpack.initialise();

        

        boolean usingBackpack = true;
        boolean using = true;
        while (usingBackpack) {
            System.out.println("""
                Welcome to Backpack
                1. Enter as instructor
                2. Enter as student
                3. Exit""");

            int userType = Integer.parseInt(scanner.nextLine());
            if ( userType == 3 ) {
                System.out.println("Exiting Backpack");
                using = false;
                return;
            }
            else if ( userType == 1 || userType == 2) {
                using = true;
            }
            else{
                using = false;
            }
            
            User personUsing = null;
            if ( using){
                //This returns the user that is currently using the backpack
                personUsing = Backpack.enterBackpack(userType);
            }
            
            while (using){
                personUsing.menuForUser();
                int action = Integer.parseInt(scanner.nextLine());
                //TODO: solve errors (try-catch)
                personUsing.perform(action);

                using = personUsing.Using();
            }
        }

    }
}
