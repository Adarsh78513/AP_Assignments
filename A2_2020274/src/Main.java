import java.util.Scanner;

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

            int userType = 100;
            boolean done = false;
            do{
                String temp = scanner.nextLine();
                try {
                    userType = Integer.parseInt(temp);

                    done = true;
                }catch(Exception e){
                    System.out.println("\n" + "\"" + temp +"\"" + " Is not a valid input.\n");
                    System.out.println("Please choose from the following");
                    System.out.println("""
                        1. Enter as instructor
                        2. Enter as student
                        3. Exit""");

                }
            }while(!done);

            if ( userType == 3 ) {
                System.out.println("Exiting Backpack");
                using = false;
                return;
            }
            else using = userType == 1 || userType == 2;
            
            User personUsing = null;
            if ( using){
                //This returns the user that is currently using the backpack
                personUsing = Backpack.enterBackpack(userType);
            }

            if ( personUsing == null){
                continue;
            }

            while (using){
                personUsing.menuForUser();

                //Getting the proper input
                int action = 0;
                done = false;
                do{
                    String temp = scanner.nextLine();
                    try {
                        action = Integer.parseInt(temp);

                        done = true;
                    }catch(Exception e){
                        System.out.println("\n" + "\"" + temp +"\"" + " Is not a valid input.\n");
                        System.out.println("Please choose from the following\n");
                        personUsing.menuForUser();

                    }
                }while(!done);

                personUsing.perform(action);

                using = personUsing.Using();
            }
        }

    }
}
