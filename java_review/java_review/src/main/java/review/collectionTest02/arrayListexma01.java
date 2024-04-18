package review.collectionTest02;

import java.util.ArrayList;
import java.util.Collections;

public class arrayListexma01 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("8");
        arr.add("9");
        arr.add("10");

        Collections.shuffle(arr);

        System.out.println(arr);

    }
}
