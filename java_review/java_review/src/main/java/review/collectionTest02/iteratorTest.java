package review.collectionTest02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class iteratorTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");

        HashSet<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");

        HashMap<String, String> map = new HashMap<String, String>();

        Iterator<String> iterList = list.iterator();
        Iterator<String> iterSet = set.iterator();
        Iterator<String> iterMap = map.keySet().iterator();

        //값 꺼내기
//        while(iterList.hasNext()){
//            System.out.println(iterList.next());
//        }

        System.out.println(iterList.next());
        iterList.remove();
        System.out.println("remove test");

    }
}
