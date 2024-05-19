import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> filteredWords = words.stream()
                .filter(w -> w.length() >= 5)
                .distinct()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(filteredWords);

    }
}
