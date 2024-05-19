import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam5 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Banana", "Apple", "Cherry", "Date");

        List<String> sortedFruits = fruits.stream()
                .sorted() // 오름차순 정렬
                .collect(Collectors.toList());
        List<String> reverseSortedFruits = fruits.stream()
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                .collect(Collectors.toList());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
// forEach 사용 예시
        numbers.stream()
                .forEach(n -> System.out.println("Number: " + n));
// peek 사용 예시
        List<Integer> doubledNumbers = numbers.stream()
                .peek(n -> System.out.println("Processing 1: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Processing 2: " + n))
                .collect(Collectors.toList());

    }
}
