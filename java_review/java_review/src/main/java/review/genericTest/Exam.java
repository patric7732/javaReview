package review.genericTest;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class Exam {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("test");
        list.add(10);
        // new Integer(10) 이 생략된 것임.
        list.add(new Book());

        System.out.println(list);

    }
}
