package review.collectionTest02;

import java.util.HashSet;
import java.util.Set;

public class setExam01 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("my");
        set.add("brother");

        System.out.println(set);

        Set<Pen> penSet = new HashSet<>();
        penSet.add(new Pen("red"));
        penSet.add(new Pen("black"));
        penSet.add(new Pen("blue"));

        System.out.println(penSet);
        penSet.add(new Pen("red"));
        System.out.println(penSet);
    }
}
