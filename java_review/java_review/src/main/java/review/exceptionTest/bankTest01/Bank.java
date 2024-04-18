//package review.exceptionTest.bankTest01;
//
//import com.example.day08.bankTest.AccountNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Bank {
//    private String BankName;
//    private List<Account> accounts;
//
//    public Bank(String bankName) {
//        this.BankName = bankName;
//        this.accounts = new ArrayList<>();
//    }
//
//    public String getBankName() {
//        return BankName;
//    }
//
//    public List<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void makeAccount(String accountNumber, String accountOwner){
//        accounts.add(new Account(accountNumber, accountOwner));
//    }
//
//    public Account checkAccount(String accountNumber) throws AccountNotFoundException{
//        for(Account acc : accounts) {
//            if (acc.getAccountNumber().equals(accountNumber)) {
//                return acc;
//            }
//        }
//        throw new AccountNotFoundException("통장을 찾을 수 없습니다.");
//    }
//}
