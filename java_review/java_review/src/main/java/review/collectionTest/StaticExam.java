package review.collectionTest;

public class StaticExam {
    int i = 10;

    static int si = 20;

    public void m1(){
        System.out.println(i);
        System.out.println(si);
        sm();
    }

    public static void sm(){
        // 불가능, 시작 지점이 다름.
//        System.out.println(i);
        System.out.println(si);
//        m1();
        //시점이 다르기 때문에 안 만들어짐
    }
}
