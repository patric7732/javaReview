package review.collectionTest02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }


    @Override
    public int compareTo(Person o) {
        // 나이를 기준으로 오름차순 정렬
//        return this.age - o.age;
    return this.name.compareTo(o.name);
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("kang",30));
        list.add(new Person("lee",12));
        list.add(new Person("jeon",14));
        list.add(new Person("hong",27));
        list.add(new Person("ko",34));
        list.add(new Person("min",53));

        System.out.println(list);
        Collections.sort(list);

        System.out.println(list);
    }


}
