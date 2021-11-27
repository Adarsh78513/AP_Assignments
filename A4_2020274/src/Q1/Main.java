package Q1;

import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello form Q1.");

        Bill b = new Bill();

        boolean placingBooks = true;
        while (placingBooks) {
            System.out.println();
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("Enter the number of the book: ");
            System.out.println("Enter 0 to stop placing books.");
            Bill.printAllBooksSorted();
            int bookNumber = scanner.nextInt();
            if ( bookNumber == 0) {
                placingBooks = false;
                continue;
            }
            int rakeNum = ((bookNumber - 1)/ Rakes.numberOfLSlots) + 1;
            int slotNum = (bookNumber) % Rakes.numberOfLSlots;
            if (slotNum == 0) {
                slotNum = Rakes.numberOfLSlots;
            }
            
            System.out.println("Place this book in the rack number " + rakeNum + ".");
            System.out.println("In the slot number " + bookNumber % Rakes.numberOfLSlots + ".");
        }

    }
}
