package review.exceptionTest.bankTest;

public class Banker {
    private String name;
    private String bankerName;
    private Bank bank;

    public Banker(String name, String bankerName, Bank bank) {
        this.name = name;
        this.bankerName = bankerName;
        this.bank = bank;
    }

    public void accountOpening(String accountNumber, String accountOwner) {
        bank.openAccount(accountNumber, accountOwner);
        System.out.println("통장이 성공적으로 열렸습니다. " + accountOwner);
    }

    public void approveWithdrawal(String accountNumber, int amount) {
        try {
            Account account = bank.getAccount(accountNumber);
            account.withdrawal(amount);
            System.out.println("출금 승인 : " + amount);
        } catch (AccountNotFoundException | InsufficientFundsException e) {
            System.out.println("출금 실패 : " + e.getMessage());
        }
    }

}
