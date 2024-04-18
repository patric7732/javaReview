package review.exceptionTest.bankTest01;

public class Exception {

    public class InsufficientFundsException extends java.lang.Exception {
        public InsufficientFundsException(String message){
            super(message);
        }
    }

    public class AccountNotFoundException extends java.lang.Exception {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }

}
