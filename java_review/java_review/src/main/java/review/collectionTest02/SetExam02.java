package review.collectionTest02;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetExam02 {
    public static void main(String[] args) {
        String input = "banana";
        Set<Character> chars = new LinkedHashSet<>();

        for (char ch : input.toCharArray()) {
            chars.add(ch);
//        System.out.println(ch);
        }
        // 순서 유지하면서 중복 제거된 문자 출력
        for (char ch : chars){
            System.out.println(ch);
        };
    }
}
