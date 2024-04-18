//package review.exceptionTest.bank;
//
//import com.example.day08.bank.BankException.InsufficientFundsException;
//
//public class Account {
//    private String accountNumber;
//    private String accountHolderName;
//    private double balance;
//
//    public Account(String accountNumber, String accountHolderName) {
//        this.accountNumber = accountNumber;
//        this.accountHolderName = accountHolderName;
//        this.balance = 0.0;
//    }
//
//    public void deposit(double amount) {
//        balance += amount;
//    }
//
//    public void withdrawal(double amount) throws InsufficientFundsException {
//        if (balance < amount) {
//            throw new InsufficientFundsException("잔액 부족");
//        }
//        balance -= amount;
//    }
//
//    public String getAccountNumber() {
//        return accountNumber;
//    }
//
//    public String getAccountHolderName() {
//        return accountHolderName;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//
//}
