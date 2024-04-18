package review.collectionTest02;

import java.util.ArrayList;
import java.util.Arrays;

public class listTest02 {
    public static void main(String[] args) {
        String[] data = {"철수", "영희"};
        ArrayList<String> name = new ArrayList<>(Arrays.asList(data));

        System.out.println(name);

    }
}
