package review.exceptionTest.bankTest;

public class Account {
    private String accountNumber;
    private String accountOwner;
    private double balance;

    public Account(String accountNumber, String accountOwner){
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdrawal(int amount) throws InsufficientFundsException {
        if(balance < amount){
            throw new InsufficientFundsException("잔액 부족");
        }
        balance -= amount;
        System.out.println("금액 " + amount + "원이 출금 되었습니다.");
    }
}
