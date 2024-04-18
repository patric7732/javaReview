package review.genericTest;

import java.util.ArrayList;
import java.util.List;

public class CollectionExam {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        System.out.println(strList.size());
        strList.add("ㄱㄱ");
        strList.add("ㅎㅎ");
        strList.add("ㅠㅠ");
        System.out.println(strList.size());

        System.out.println(strList);
        strList.add("ㄱㄱ");
        strList.add("ㅎㅎ");
        strList.add("ㅠㅠ");
        strList.add("ㄱㄱ");
        strList.add("ㅎㅎ");
        strList.add("ㅠㅠ");
        strList.add("ㄱㄱ");
        strList.add("ㅎㅎ");
        strList.add("ㅠㅠ");
        strList.add("ㄱㄱ");
        strList.add("ㅎㅎ");
        strList.add("ㅠㅠ");
        System.out.println(strList.size());

        for(String str : strList){
            System.out.println(str);
        }

        System.out.println(strList.get(3));

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");

        for (String str : list){
            System.out.println(str);
        }

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
    }
}
