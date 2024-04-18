package review.exceptionTest.bank;

public class BankException {
    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    public class AccountNotFoundException extends Exception {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }
}
