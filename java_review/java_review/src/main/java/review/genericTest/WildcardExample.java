package review.genericTest;

import java.util.Arrays;
import java.util.List;

public class WildcardExample {
    public static void printList(List<?> list){
        for (Object element : list){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,3,4);
        List<String> stringList = Arrays.asList("hi", "hello");
        List<Double> doubleList = Arrays.asList(1.3, 2.4, 5.3);

        System.out.println(integerList);
        System.out.println(stringList);
        System.out.println(doubleList);
    }
}
