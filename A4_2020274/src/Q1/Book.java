package Q1;

public class Book{
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
        return "BookTitle=" + bookTitle + ", ISBN=" + ISBN + ", barcode=" + barcode;
    }

}
