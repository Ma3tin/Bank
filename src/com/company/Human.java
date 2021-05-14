package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Human {
    private String name;
    private String surname;
    private long idNumber;
    private long phoneNumber;
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private int money;

    public Human() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte vaše jméno.");
        setName(sc.nextLine());
        System.out.println("Zadejte vaše příjmení.");
        setSurname(sc.nextLine());
        System.out.println("Zadejte rodné číslo.");
        setIdNumber(Integer.parseInt(sc.nextLine()));
        System.out.println("Zadejte telefonní číslo.");
        setPhoneNumber(Integer.parseInt(sc.nextLine()));
        System.out.println("Zadejte kolik máte pěnez.");
        setMoney(Integer.parseInt(sc.nextLine()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



}
