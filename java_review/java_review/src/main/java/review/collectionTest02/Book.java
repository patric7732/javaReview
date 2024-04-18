package review.collectionTest02;

public class Book {
    public String bookName;
    public String bookOwner;
    public int day;



    public Book(String bookName, String bookOwner, int day) {
        this.bookName = bookName;
        this.bookOwner = bookOwner;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookOwner='" + bookOwner + '\'' +
                ", day=" + day +
                '}';
    }
}


