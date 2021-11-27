package Q1;

import java.util.ArrayList;
import java.util.Collections;

public class Bill {
    public static ArrayList<Book> billList = new ArrayList<>();
    public static ArrayList<Book> sortedList = new ArrayList<>();

    {
        billList.add(new Book("The Great Gatsby", 12345, 123_456_789));
        billList.add(new Book("The Great Gatsby", 12345, 123_456_780));
        billList.add(new Book("The Great Gatsby", 12345, 123_456_781));
        billList.add(new Book("The Lord of the Rings", 123434, 123_456_782));
        billList.add(new Book("The Hobbit", 1234344, 123_456_783));
        billList.add(new Book("The Little Prince", 123434, 123_456_784));
        billList.add(new Book("The Alchemist", 123456, 123_456_785));
        billList.add(new Book("The Count of Monte Cristo", 124456, 123_456_786));
        billList.add(new Book("The Alchemist", 133456, 123_456_787));
        billList.add(new Book("The Count of Monte Cristo", 144556, 123_456_788));
        billList.add(new Book("Harry Potter", 154956, 123_456_789));
        billList.add(new Book("The Count of Monte Cristo", 164556, 123_456_790));
        billList.add(new Book("Harry Potter", 174556, 123_456_791));
        billList.add(new Book("The Count of Monte Cristo", 184556, 123_456_792));
        billList.add(new Book("The Alchemist", 194556, 123_456_793));
        billList.add(new Book("The Count of Monte Cristo", 204556, 123_456_794));
        billList.add(new Book("The Alchemist", 214566, 123_456_795));

        sortedList.addAll(billList);


        //printing the bill before any sorting
        System.out.println("The bill has this information: ");
        for ( Book book : billList) {
            System.out.println(book.toString());
        }

        //sorting the books
        Collections.sort(sortedList);

        System.out.println("------------------------------------------------------");
        //printing the bill after sorting
        System.out.println("The bill after sorting: ");
        for ( Book book : sortedList) {
            System.out.println(book);
        }
    }

    public static void printAllBooksSorted(){
        int i = 0;
        for ( Book book : sortedList) {
            System.out.print(++i + ". ");
            System.out.println(book);
        }
    }
}
