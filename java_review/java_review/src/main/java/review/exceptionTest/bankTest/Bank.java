package review.exceptionTest.bankTest;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String BankName;
    private List<Account> accounts;

    public Bank(String bankName) {
        this.BankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public void openAccount(String accountNumber, String accountOwner) {
        Account account = new Account(accountNumber, accountOwner);
        accounts.add(account);
        System.out.println("계좌가 개설되었습니다: " + accountNumber);
    }

    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("계좌를 찾을 수 없습니다 : " + accountNumber);
    }

}
