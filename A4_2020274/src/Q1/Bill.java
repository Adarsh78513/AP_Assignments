package Q1;

import java.util.ArrayList;

public class Bill {
    static {
        ArrayList<Book> billList= new ArrayList<Book>();
        for ( int i = 0; i <  10 ; i++ ) {
            billList.add(new Book(randomString(), randomInt(), randomInt()));
        }


        //printing the bil before any sorting
        System.out.println("The bill has this information: ");
        for ( Book book : billList) {
            System.out.println(book.toString());
        }
    }

    //function to create random string
    public static String randomString(){
        //String length less than or equal to 10
        int stringLength = (int) (Math.random() * 10) + 1;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            s.append((char) ((Math.random() * 26) + 'a'));
        }
        return s.toString();
    }

    public static int randomInt(){
        return (int) (Math.random() * 9999999) + 1;
    }
}
