package review.collectionTest02;

import java.util.ArrayList;

public class listTest {
    public static void main(String[] args) {
    ArrayList name = new ArrayList();
    name.add("철수");
    name.add("영희");

        System.out.println(name);
        System.out.println(name.get(1));
        System.out.println(name.size());
        System.out.println(name.contains("철수"));

        name.remove(0);
        System.out.println(name);
        
    }
}
