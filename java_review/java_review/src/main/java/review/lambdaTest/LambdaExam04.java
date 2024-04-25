import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExam04 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        Consumer<String> printConsumer = name -> System.out.println(name);
        names.forEach(printConsumer);
    }
}
