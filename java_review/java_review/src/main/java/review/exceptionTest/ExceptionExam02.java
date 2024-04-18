package review.exceptionTest;

public class ExceptionExam02 {
    public static void main(String[] args) {
        System.out.println("프로그램 시작!!");

        int i = Integer.parseInt(args[0]);

        try {
            System.out.println(10 / i);
        }catch (ArithmeticException e){
            System.out.println("오류");
            System.out.println(e);
        }

        System.out.println("프로그램 종료");
    }
}
