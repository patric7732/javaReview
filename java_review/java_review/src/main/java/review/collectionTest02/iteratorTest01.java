package review.collectionTest02;

import java.util.ArrayList;
import java.util.Iterator;

public class iteratorTest01 {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("사과");
        fruits.add("포도");
        fruits.add("딸기");

        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println(fruit);
        }
    }
}
