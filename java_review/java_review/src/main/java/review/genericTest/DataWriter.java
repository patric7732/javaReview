package review.genericTest;

import java.util.ArrayList;
import java.util.List;

public class DataWriter {
    public static void addNumber(List<? super Integer> list){
        for ( int i = 1; i<=5; i++){
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumber(numberList);
        addNumber(objectList);

        System.out.println("numberList: " + numberList);
        System.out.println("objectList: " + objectList);
    }
}
