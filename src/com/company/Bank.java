package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }


    public void makeNewAccount(int moneyCount) {
        BankAccount bankAccount = new BankAccount();
        Random rd = new Random();
        String number = "";
        for (int i = 0; i <= 9; i++) {
            number += rd.nextInt(9) + 1;
        }
        bankAccount.setAccountNumber(Long.parseLong(number));
        bankAccount.setMoneyCount(moneyCount);
        bankAccounts.add(bankAccount);
    }

    public void removeAccount(long accountNumber) {
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (bankAccounts.get(i).getAccountNumber() == accountNumber) bankAccounts.remove(i);
        }
    }

    public BankAccount findBankAccount(long accountNumber) {
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (bankAccounts.get(i).getAccountNumber() == accountNumber) return bankAccounts.get(i);
        }
        return null;
    }


}
