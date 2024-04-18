package review.exceptionTest;

public class ExceptionExam1 {
    public static void main(String[] args) {
        int [] arr = {1,2,3};

        try{
            int result = 10/0;
            System.out.println(arr[3]);

//        } catch(ArrayIndexOutOfBoundsException e){
////            System.out.println(arr[0]);
//            System.out.println(e.toString());
//            System.out.println(e.getMessage());
//
//        } catch (ArithmeticException e){
//            System.out.println(e);
//            System.out.println(e.toString());
//            System.out.println(e.getMessage());

        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("예외 처리 성공");
    }
}

// 중복된 에러가 있을 경우 무조건적으로 처리가 불가능함.
// 에러가 발생한 구문 try 블럭 안에는 에러를 실행한 그 시점부터 try는 실행을 못함
