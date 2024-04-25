//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class LambdaTest1 {
//    public static void main(String[] args) {
//        List<String> words = Arrays.asList("Apple", "banana", "cherry", "grape", "peach");
//        Collections.sort(words, (a, b) -> a.length() - b.length());
//        System.out.println(words);
//
//        // 문제 2: 최대값 찾기
//        List<Integer> numbers = Arrays.asList(1,3,4,5,6,7,34,24);
//        Collections.sort(numbers, (Integer a, Integer b) -> {
//            return a.compareTo(b);
//        });
//        System.out.println(numbers.get(numbers.size()-1));
//
//        // 문제 3: 리스트의 각 요소에 연산 적용하기
//        List<Integer> numbersTen = Arrays.asList(1,3,4,5,6,7,34,24);
//        List<Integer> plusTen = new ArrayList<>();
//        numbersTen.forEach(n -> plusTen.add(n + 10));
//        System.out.println(plusTen);
//
//        List<Integer> numbers3 = List.of(1, 2, 3, 4, 5);
//        List<Integer> squaredNumbers = new ArrayList<>();
//
//        numbers.forEach(n -> squaredNumbers.add(n * n));
//        System.out.println(squaredNumbers);
//
////        List<Integer> numbers3 = List.of(2, 4, 6, 8, 10);
//        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
//        System.out.println("Are all numbers even? " + allEven);
//    }
//    }
//}
