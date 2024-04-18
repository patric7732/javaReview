package review.collectionTest02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookManager {
    private List<Book> Books = new ArrayList<>();
    public void addBook(Book book){
        Books.add(book);
        System.out.println("책이 추가되었습니다. " + book);
    }

    public void displayBooks(){
        System.out.println("Displaying books:");
        for (Book book : Books) {
            System.out.println(book);
        }
    }

    public void sortBooksByYear(){
        Collections.sort(Books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Integer.compare(b1.day, b2.day);
            }
        });
        System.out.println("책을 날짜별로 정렬합니다.");
    }
}
