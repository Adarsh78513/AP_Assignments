import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int userType = Integer.parseInt(scanner.next());

        InitialiseBackpack.initialise();
        User personUsing = Backpack.enterBackpack(userType);

        boolean using = true;
        while (using){
            personUsing.menuForUser();
            int option = Integer.parseInt(scanner.next());
            personUsing.perform(option);
        }

    }
}
