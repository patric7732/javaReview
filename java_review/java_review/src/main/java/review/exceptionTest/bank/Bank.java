package review.exceptionTest.bank;//package com.example.day08.bank;
//import com.example.day08.bank.BankException.AccountNotFoundException;
//
//import java.util.ArrayList;
//import java.util.List;
//public class Bank {
//        private String bankName;
//        private List<Account> accounts;
//
//        public Bank(String bankName) {
//            this.bankName = bankName;
//            this.accounts = new ArrayList<>();
//        }
//
//        public void openAccount(String accountNumber, String holderName) {
//            accounts.add(new Account(accountNumber, holderName));
//        }
//
//        public Account checkAccount(String accountNumber) throws AccountNotFoundException {
//            for (Account acc : accounts) {
//                if (acc.getAccountNumber().equals(accountNumber)) {
//                    return acc;
//                }
//            }
//            throw new AccountNotFoundException("Account not found: " + accountNumber);
//        }
//    }
