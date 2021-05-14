package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] bankNames = {"Airbank", "ČSOB", "Česká spořitelna", "Moneta Money Bank", "Fio banka", "Komerční banka"};
        String[] bankCodes = {"3030", "0300", "0800", "0600", "2010", "0100"};
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        Human human = new Human();
        System.out.println("Copak by jste potřeboval/a?");
        printMenu();
        int inputMenu = Integer.parseInt(sc.nextLine());
        int index = 0;
        while (inputMenu != 9) {
            if (inputMenu == 1) {
                System.out.println("Jenom pro zkontrolování, poprosíme vaše rodné číslo.");
                long birthID = Long.parseLong(sc.nextLine());
                if (birthID != human.getIdNumber()) break;
                bank.makeNewAccount(human.getMoney());
                System.out.println("Dobře, vyberte si banku u které si chcete udělat účet:");
                System.out.println("1) Airbank");
                System.out.println("2) ČSOB");
                System.out.println("3) Česká spořitelna");
                System.out.println("4) Moneta Money Bank");
                System.out.println("5) Fio banka");
                System.out.println("6) Komerční banka");
                int inputBank = Integer.parseInt(sc.nextLine());
                if (inputBank == 1) {
                     bank.getBankAccounts().get(index).setName(bankNames[inputBank - 1]);
                     bank.getBankAccounts().get(index).setCode(bankCodes[inputBank - 1]);
                } else if (inputBank == 2) {
                    bank.getBankAccounts().get(index).setName(bankNames[inputBank - 1]);
                    bank.getBankAccounts().get(index).setCode(bankCodes[inputBank - 1]);
                } else if (inputBank == 3) {
                    bank.getBankAccounts().get(index).setName(bankNames[inputBank - 1]);
                    bank.getBankAccounts().get(index).setCode(bankCodes[inputBank - 1]);
                } else if (inputBank == 4) {
                    bank.getBankAccounts().get(index).setName(bankNames[inputBank - 1]);
                    bank.getBankAccounts().get(index).setCode(bankCodes[inputBank - 1]);
                } else if (inputBank == 5) {
                    bank.getBankAccounts().get(index).setName(bankNames[inputBank - 1]);
                    bank.getBankAccounts().get(index).setCode(bankCodes[inputBank - 1]);
                } else if (inputBank == 6) {
                    bank.getBankAccounts().get(index).setName(bankNames[inputBank - 1]);
                    bank.getBankAccounts().get(index).setCode(bankCodes[inputBank - 1]);
                }

                System.out.println("Vaše číslo účtu je: " + bank.getBankAccounts().get(index).getAccountNumber());
                System.out.println("Kód vaší banky je: " + bank.getBankAccounts().get(index).getCode());
                index++;

            } else if (inputMenu == 2) {
                System.out.print("Zadejte číslo účtu, který chcete smazat: ");
                long accountNumber = Long.parseLong(sc.nextLine());
                BankAccount bankAccount = bank.findBankAccount(accountNumber);
                try {
                    bankAccount.removeAccount(bankAccount, bank);
                    index--;
                } catch (NullPointerException e) {
                    System.out.println("Daný účet neexistuje");
                }
            } else if (inputMenu == 3) {
                System.out.print("Zadejte číslo účtu, ze kterého chcete peníze poslat: ");
                BankAccount bankAccount1 = bank.findBankAccount(Long.parseLong(sc.nextLine()));
                System.out.print("Zadejte číslo účtu, na který chcete peníze poslat: ");
                BankAccount bankAccount2 = bank.findBankAccount(Long.parseLong(sc.nextLine()));
                System.out.print("Zadejte částku, kterou chtete poslat");
                int amount = Integer.parseInt(sc.nextLine());
                try {
                    bankAccount1.sendMoney(amount, bankAccount2);
                    System.out.println("Zůstatek na prvním účtě: " + bankAccount1.getMoneyCount() + "Kč.");
                    System.out.println("Zůstatek na prvním účtě: " + bankAccount2.getMoneyCount() + "Kč.");
                } catch (NullPointerException e) {
                    System.out.println("Daný účet neexistuje");
                }
            } else if (inputMenu == 4) {
                System.out.print("Zadejte číslo účtu, na který chcete peníze přidat: ");
                long accountNumber = Long.parseLong(sc.nextLine());
                BankAccount bankAccount = bank.findBankAccount(accountNumber);
                System.out.print("Zadejte částku kterou chcete přidat: ");
                int amount = Integer.parseInt(sc.nextLine());
                try {
                    bankAccount.addMoney(amount, bankAccount);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Daný účet neexistuje");
                }
            } else if (inputMenu == 5) {
                System.out.print("Zadejte číslo účtu, ze kterého si chcete vybrat peníze: ");
                long accountNumber = Long.parseLong(sc.nextLine());
                BankAccount bankAccount = bank.findBankAccount(accountNumber);
                System.out.print("Zadejte částku kterou si chcete vybrat: ");
                int amount = Integer.parseInt(sc.nextLine());
                try {
                    bankAccount.removeMoney(amount);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Daný účet neexistuje");
                }
            } else if (inputMenu == 6) {
                System.out.print("Zadejte číslo účtu, u kterého si chcete udělat kartu: ");
                long accountNumber = Long.parseLong(sc.nextLine());

                BankAccount bankAccount = bank.findBankAccount(accountNumber);
                System.out.print("Zadejte 4 místný pin, který chcete: ");
                int pin = Integer.parseInt(sc.nextLine());
                try {
                    Card card = bankAccount.createCard(accountNumber, human, pin);
                    System.out.println("Až bude karta hotová zavoláme vám na vaše číslo: " + human.getPhoneNumber());
                    System.out.println("Karta bude vytvořena na jméno: " + card.getFullName());
                    System.out.println("Číslo karty bude: " + card.getCardNumber());
                    System.out.println("Pin bude: " + card.getPinCode());
                    System.out.println("Verifikační kód bude: " + card.getCardVerificationCode());
                } catch (NullPointerException e) {
                    System.out.println("Daný účet neexistuje");
                }
            } else if (inputMenu == 7) {
                for (int i = 0; i < bank.getBankAccounts().size(); i++) {
                    System.out.println((i + 1) + ". číslo účtu: " + bank.getBankAccounts().get(i).getAccountNumber() + "; Jméno banky: " + bank.getBankAccounts().get(i).getName() + "; Číslo banky: " + bank.getBankAccounts().get(i).getCode());
                }
            } else if (inputMenu == 8) {
                System.out.print("Zadejte číslo účtu u kterého si chcete zjistit zůstatek: ");
                long accountNumber = Long.parseLong(sc.nextLine());
                System.out.println("Váš zůstatek: " + bank.findBankAccount(accountNumber).getMoneyCount() + " Kč.");
            }
            System.out.println("Copak by jste dál potřeboval/a?");
            printMenu();
            inputMenu = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Děkujeme nashledanou");
    }
    public static void printMenu() {
        System.out.println("1) Založit účet.");
        System.out.println("2) Smazat účet.");
        System.out.println("3) Poslat peníze z účtu na jiný účet.");
        System.out.println("4) Přidat peníze na účet.");
        System.out.println("5) Vybrat peníze z účtu.");
        System.out.println("6) Založit kartu.");
        System.out.println("7) Ukázat mé bankovní účty.");
        System.out.println("8) Zůstatek na mém účtě.");
        System.out.println("9) Odejít z banky.");
    }
}
