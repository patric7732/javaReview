package review.exceptionTest.bankTest01;


import com.example.day08.bankTest.AccountNotFoundException;
import java.util.Scanner;

public class BankDemo {
    private static final int CREATE_BANK = 1;
    private static final int  DISPLAY_BANK= 2;
    private static final int DEPOSIT = 3;
    private static final int WITHDRAW = 4;
    private static final int EXIT = 5;
    public static void main(String[] args) throws AccountNotFoundException {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("JUN");

        while(true){
            System.out.println("==============================");
            System.out.println(bank.getBankName() +"은행에 오신 것을 환영합니다.");
            System.out.println("원하시는 업무를 입력하세요.");
            System.out.println("1. 계좌 개설, 2. 계좌 조회, 3. 입금, 4. 출금, 5. 프로그램 종료 : ");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println("==============================");


            switch(choice) {
                case CREATE_BANK:
                    System.out.println("개설하실 통장의 번호를 입력해주세요.");
                    String account = sc.nextLine();
                    System.out.println("본인의 이름을 입력하세요.");
                    String name = sc.nextLine();
                    bank.makeAccount(account, name); // 통장 개설
                    System.out.println("계좌가 만들어졌습니다.");
                    break;
                case DISPLAY_BANK:
                    for (Account acc : bank.getAccounts()) {
                        System.out.println("계좌번호: " + acc.getAccountNumber() + ", 소유주: " + acc.getAccountOwner() + ", 통장 잔액: " + acc.getBalance());
                    }
                    System.out.println("현재 보유하신 통장입니다, 조회하실 통장 번호를 입력하세요.");
                    String accountNumber = sc.nextLine();
                    Account acc = bank.checkAccount(accountNumber);
                    System.out.println("계좌번호: " + acc.getAccountNumber() + ", 소유주: " + acc.getAccountOwner() + ", 통장 잔액: " + acc.getBalance());
                    break;
                case DEPOSIT:
                    System.out.println("입금하실 계좌 번호를 입력하세요.");
                    accountNumber = sc.nextLine();
                    bank.checkAccount(accountNumber);
                    bank.getAccounts();
                    System.out.println("현재 보유하신 잔액입니다, 입금하실 금액을 입력하세요.");
                    int amount = sc.nextInt();



            }
        }


    }
}
