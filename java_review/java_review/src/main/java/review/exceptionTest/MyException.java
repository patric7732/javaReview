package review.exceptionTest;

public class MyException extends RuntimeException {
    public MyException(){
        super("the score upper 0 and down 100");
    }
}
