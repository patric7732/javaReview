package review.exceptionTest.bankTest01;


import review.exceptionTest.bankTest.InsufficientFundsException;

public class Account {
    private String accountNumber;
    private String accoutOwner;
    private int balance;

    public Account(String accountNumber, String accoutOwner) {
        this.accountNumber = accountNumber;
        this.accoutOwner = accoutOwner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwner() {
        return accoutOwner;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        balance -= amount;
        if (balance<amount){
            throw new InsufficientFundsException("출금하는 금액보다 잔액이 부족합니다.");
        }
    }

}
