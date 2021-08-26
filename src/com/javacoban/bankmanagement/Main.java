package com.javacoban.bankmanagement;


// Những hành động phía user:
//+ inputInfo : scan
//        + display: sout (toString)
//        + Menu : show menu

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AccountManagement accountManagement = new AccountManagement();
        showMenu();
        while (true) {
            int number = scanner.nextInt();
            switch (number) {

                case 1:
                    Account account = inputInfor();
                    accountManagement.addAccount(account);
                    break;
                case 2:
                case 3:
                case 4:
                    ArrayList<Account> accountList = accountManagement.getList();
                    for (Account acc: accountList) {
                        display(acc);
                    }
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return;
                default:
            }

        }
            }

    public static void showMenu() {
        System.out.println("Welcome to the Agribank");
        System.out.println("Please choose an action: ");
        System.out.println("1. Add Account");
        System.out.println("2. Delete Account");
        System.out.println("3. Search Account");
        System.out.println("4. Display all");
        System.out.println("5. Add money for an account");
        System.out.println("6. Withdraw money from an account");
        System.out.println("7. Transfer money");
        System.out.println("8. Show menu");
        System.out.println("9. Exist");
    }

    public static Account inputInfor() {
        System.out.println("Please input infor of an account: ");
        System.out.print(" ID: ");
        long ID = scanner.nextLong();
        scanner.nextLine();
        System.out.print(" accountName: ");
        String accountName = scanner.nextLine();
        double initialMoney = 50000;
        return new Account(ID, accountName, initialMoney);
    }

    public static void display(Account account) {
        System.out.println(account.toString());
    }

}
