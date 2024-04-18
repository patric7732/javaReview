package review.genericTest;

import java.util.Arrays;
import java.util.List;

public class NumberProcessor {
    public static <T extends Number> double sum(List<T> numbers){
        double total = 0.0;
        for(Number number : numbers){
            total += number.doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.3, 3.2, 4.5);

        System.out.println(sum(integerList));
        System.out.println(sum(doubleList));
    }
}
