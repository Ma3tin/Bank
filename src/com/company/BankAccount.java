package com.company;

import java.util.Random;

public class BankAccount {
    private long accountNumber;
    private long moneyCount;
    private boolean card;
    private String Code;
    private String name;


    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(long moneyCount) {
        this.moneyCount = moneyCount;
    }

    public boolean isCard() {
        return card;
    }

    public void setCard(boolean card) {
        this.card = card;
    }


    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Card createCard(long accountNumber, Human human, int pinCode) {
        if (isCard()) System.out.println("Již máte kartu!");
        else {
            Card card = new Card();
            Random random = new Random();
            card.setFullName(human.getName() + ";" + human.getSurname());
            card.setPinCode(pinCode);
            String cvc = "";
            for (int i = 0; i < 3; i++) {
                cvc += random.nextInt(9) + 1;
            }
            String cardNumber = "";
            for (int i = 0; i < 4; i++) cardNumber += random.nextInt(9) + 1;
            cardNumber += " ";
            for (int i = 0; i < 4; i++) cardNumber += random.nextInt(9) + 1;
            cardNumber += " ";
            for (int i = 0; i < 4; i++) cardNumber += random.nextInt(9) + 1;
            cardNumber += " ";
            for (int i = 0; i < 4; i++) cardNumber += random.nextInt(9) + 1;
            card.setCardNumber(cardNumber);
            card.setCardVerificationCode(cvc);
            setCard(true);
            System.out.println("Karta byla vytvořena");
            return card;
        }
        return null;
    }

    public void addMoney(int amount, BankAccount bankAccount) {
        bankAccount.setMoneyCount(bankAccount.getMoneyCount() + amount);
    }

    public void removeMoney(int amount) {
        BankAccount bankAccount = new BankAccount();
        if (bankAccount.getMoneyCount() < amount) System.out.println("Nedostatek pěnez");
        else bankAccount.setMoneyCount(bankAccount.getMoneyCount() - amount);
    }

    public void removeAccount(BankAccount bankAccount, Bank bank) {
        for (int i = 0; i < bank.getBankAccounts().size(); i++) {
            if (bank.getBankAccounts().get(i) == bankAccount) bank.getBankAccounts().remove(i);
        }
    }
}
