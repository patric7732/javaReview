package review.genericTest;

import java.util.ArrayList;
import java.util.List;

public class WildcardVsGeneric {
    public static void addNumber(List<?> list){

    }

    public static <T> void addNumberGeneric(List<T> list, T element){
        list.add(element);
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        addNumberGeneric(integerList, 10);
        addNumberGeneric(stringList, "hi");

        System.out.println(integerList);
        System.out.println(stringList);
    }
}
