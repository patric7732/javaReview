package review.exceptionTest.bankTest;


import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("예제");
        Banker banker = new Banker("익명1", "123", bank);

        // Prompt for and read the account holder's name
        System.out.println("이름을 입력하세요. : ");
        String accountOwner = scanner.nextLine();

        // Prompt for and read the account number
        System.out.println("통장 번호를 입력하세요. :");
        String accountNumber = scanner.nextLine();

        // Now, use the banker to approve the account opening with the entered details
        banker.accountOpening(accountNumber, accountOwner);

        // Demonstration of deposit and withdrawal with Scanner (optional)
        try {
            System.out.println("입금 금액: ");
            int depositAmount = scanner.nextInt();
            bank.getAccount(accountNumber).deposit(depositAmount);

            // Assuming successful deposit, prompt for withdrawal
            System.out.println("출금 금액: ");
            int withdrawalAmount = scanner.nextInt(); // Make sure to handle InputMismatchException for non-numeric inputs
            scanner.nextLine(); // Consume newline left-over

            banker.approveWithdrawal(accountNumber, withdrawalAmount);

            // Show balance
            Account account = bank.getAccount(accountNumber);
            System.out.println("Current balance: " + account.getBalance());
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // It's important to close the scanner when done
        }
    }
}
