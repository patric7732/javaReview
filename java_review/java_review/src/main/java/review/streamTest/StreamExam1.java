import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamExam1 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a", "b", "c", "d", "f");

        List<String> filteredList = myList.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());

        System.out.println(filteredList);

        for (String s : myList) {
            if (s.startsWith("a")) {
                filteredList.add(s);
            }
        }

        String[] names = {"kang", "kim", "hong", "lee", "son"};

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("==============================");
        Arrays.stream(names).forEach(System.out::println);
        // 위랑 아래랑 같은 식, 람다의 차이
        Arrays.stream(names).forEach(name -> System.out.println(name));
        // 위의 코드랑 똑같은 식임
        Arrays.stream(names).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        int[] iarr = {1, 2, 3, 4, 5, 6, 7, 8};

        // 짝수만 출력
        for (int i = 0; i < iarr.length; i++) {
            if (iarr[i] % 2 == 0) {
                System.out.println(iarr[i]);
            }
        }

        System.out.println("----------------------");
        Arrays.stream(iarr).filter(i -> i % 2 == 0).forEach(System.out::println);

        List<String> words = Arrays.asList("appple", "banana", "road", "hash", "road");
        List<String> unique = words.stream().filter(word -> word.length() > 5)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(unique);
    }
}
