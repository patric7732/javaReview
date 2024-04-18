package review.collectionTest02;

import java.util.ArrayList;
import java.util.Collections;

public class listTest03 {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("BlueBerry");
        fruits.add("StrawBerry");
        fruits.add("Banana");
        fruits.add("Grape");
        System.out.println(fruits);
        Collections.shuffle(fruits);
        System.out.println(fruits);
    }
}
