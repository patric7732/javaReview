package review.collectionTest02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("kanag");
        list.add("kim");
        list.add("wang");
        list.add("jeon");
        list.add("park");
        list.add("go");

        Collections.sort(list);

        System.out.println(list);


    }
}
