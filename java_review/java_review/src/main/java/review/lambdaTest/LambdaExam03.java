import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExam03 {
    public static void main(String[] args) {
        //Predicate
        //조건을 테스트하는데 사용.  boolean값 반환
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-10));

        //Consumer
        //입력을 받고 반환값이 없는 연산을 수행
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("hello carami!!");

        //Function
        //입력을 받아서 출력을 반환하는..
        Function<String, Integer> lengthFunc = s -> s.length();
        System.out.println(lengthFunc.apply("hello carami!!"));

        //Supplier
        //입력 없이 값을 반환
        Supplier<Double> randomSupplier = () -> Math.random();

        System.out.println(randomSupplier.get());
    }
}