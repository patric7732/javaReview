package review.collectionTest;

public class throwableExam {
    public static void main(String[] args) {
        try{
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println();
        }
    }
}
