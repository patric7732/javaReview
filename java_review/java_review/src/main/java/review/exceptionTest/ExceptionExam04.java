package review.exceptionTest;

public class ExceptionExam04 {
    public static void Order() {
        // 직접 예외처리를 함
        System.out.println("Order start");

        int i = 0;
        try {
            System.out.println(10 / i);
        }catch (Exception e){
            System.out.println("Order Error");
            System.out.println("Going to other mart");

        }
        System.out.println("Order end");
    }

    public static void Order2() throws Exception {
        // 예외를 직접 처리 안하고 사용자에게 던짐
        System.out.println("Order start");

        int i = 0;
            System.out.println(10 / i);

        System.out.println("Order end");
    }

    public static void main(String[] args) {
        try{
            Order2();
        }catch (Exception e){
            System.out.println("Order brother");

        }
        System.out.println("Order end");
    }
}
