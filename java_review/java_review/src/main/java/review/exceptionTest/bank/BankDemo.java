package review.exceptionTest.bank;//package com.example.day08.bank;
//import com.example.day08.bank.BankException.AccountNotFoundException;
//
//public class BankDemo {
//    public static void main(String[] args) {
//        Bank bank = new Bank("Example Bank");
//        Banker banker = new Banker("John Doe", "B123", bank);
//
//        banker.approveAccountOpening("12345", "Alice Smith");
//
//        try {
//            bank.checkAccount("12345").deposit(500);
//            banker.approveWithdrawal("12345", 100);
//            Account aliceAccount = bank.checkAccount("12345");
//            System.out.println("Balance: " + aliceAccount.getBalance());
//        } catch (AccountNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (AccountNotFoundException e) {
//        }
//    }
//}
