package review.basicTest;

public class forTest {
    public static void main(String[] args) {
//        for (int i = 0; i <= 10; i++){
//            System.out.println(i);

        for (int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                System.out.println(i + "*" + j + "=" + i*j);
            }
            System.out.println();
        }
    }
}
