import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam4 {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Cherry", "Date")
        );
        List<String> flattenedList = nestedList.stream() // 스트림 생성
                .flatMap(Collection::stream) // 리스트를 평탄화
                .collect(Collectors.toList()); // 결과 수집
        System.out.println(flattenedList);


        List<String> list = Arrays.asList("hello java!!", "hi carami", "lambda stream");
        list.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(System.out::println);

        List<String> list2 = Arrays.asList("1 ,3,  4,6  ,7  ,8,  9");
        list2.stream()
                .flatMapToInt(
                        data -> {
                            String[] strArr = data.split(",");
                            int[] intArr = new int[strArr.length];
                            for (int i = 0; i < strArr.length; i++) {
                                intArr[i] = Integer.parseInt(strArr[i].trim());
                            }
                            return Arrays.stream(intArr);
                        })
                .forEach(System.out::println);


    }

}
