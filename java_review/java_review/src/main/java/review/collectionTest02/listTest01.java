package review.collectionTest02;

import java.util.ArrayList;

public class listTest01 {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("철수");
        name.add("영희");

        String nameOne = name.get(0);
        String nameTwo = name.get(1);

        System.out.println(nameOne);
    }
}
