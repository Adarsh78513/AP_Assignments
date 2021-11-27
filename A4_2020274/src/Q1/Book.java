package Q1;

public class Book implements Comparable<Book> {
    final String bookTitle;
    final int ISBN;
    final int barcode;

    Book(String bookTitle, int ISBN, int barcode) {
        this.bookTitle = bookTitle;
        this.ISBN = ISBN;
        this.barcode = barcode;
    }

    String getBookTitle() {
        return this.bookTitle;
    }
    int getISBN() {
        return this.ISBN;
    }
    int getBarcode() {
        return this.barcode;
    }

    @Override
    public String toString() {
        return "BookTitle: " + bookTitle + ", ISBN: " + ISBN + ", barcode: " + barcode;
    }


    @Override
    public int compareTo(Book b) {
        if (this.bookTitle.compareTo(b.bookTitle) != 0) {
            return this.bookTitle.compareTo(b.bookTitle);
        }else{
            if ( this.ISBN != b.ISBN) {
                return this.ISBN - b.ISBN;
            }
            else {
                return this.barcode - b.barcode;
            }
        }
    }


}
