package review.exceptionTest.bank;//package com.example.day08.bank;
//
//import com.example.day08.bank.BankException.AccountNotFoundException;
//import com.example.day08.bank.BankException.InsufficientFundsException;;
//
//public class Banker {
//    private String name;
//    private String bankerID;
//    private Bank bank;
//
//    public Banker(String name, String bankerID, Bank bank) {
//        this.name = name;
//        this.bankerID = bankerID;
//        this.bank = bank;
//    }
//
//    public void approveAccountOpening(String accountNumber, String holderName) {
//        bank.openAccount(accountNumber, holderName);
//        System.out.println("Account opened successfully for " + holderName);
//    }
//
//    public void approveWithdrawal(String accountNumber, double amount) {
//        try {
//            Account account = bank.checkAccount(accountNumber);
//            account.withdrawal(amount);
//            System.out.println("Withdrawal approved: " + amount);
//        } catch (AccountNotFoundException | InsufficientFundsException e) {
//            System.out.println("Approval failed: " + e.getMessage());
//        }
//    }
//}