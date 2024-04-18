package review.exceptionTest;

public class ExceptionExam05 {
        public static void main(String[] args) {
            int [] arr = {1,2,3};

            try{
                System.out.println("try start");
                int result = 10/2;
                System.out.println(arr[2]);

//                arr = null;
                System.out.println(arr[0]);

        } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("ArrayIndexOutOfBoundsException catch block");
                System.out.println(e.getMessage());

        } catch (ArithmeticException e) {
                System.out.println("ArithmeticException catch block");
                System.out.println(e.getMessage());

            } catch (NullPointerException e) {
                System.out.println("NullPointerException catch block");
                System.out.println(e.getMessage());

            } finally {
                System.out.println("반드시 실행됨");
                System.out.println("예외 처리 성공");
            }
    }
}
