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
        ArrayList<Account> accountList = accountManagement.getList();
        showMenu();
        while (true) {
            int number = scanner.nextInt();
            switch (number) {

                case 1:
                    Account account = inputInfor();
                    accountManagement.addAccount(account);
                    break;

                case 2:
                    System.out.println("Enter the account id need delete: ");
                    long deleteID = scanner.nextLong();
                    Account a = accountManagement.searchByID(deleteID);
                    if ( a == null ){
                        break;
                    }
                    accountManagement.removeAccount(a);
                    System.out.println("Deleted!");
                    break;

                case 3:
                    System.out.println("Enter the account id need search: ");
                    long searchID = scanner.nextLong();
                    for (Account account1 : accountList){
                        if (account1.getID() == searchID){
                            System.out.println(account1);
                        }else {
                            System.out.println("Deleted!");
                            System.out.println("List of accounts exists: ");
                        }
                        break;
                    }
                    break;

                case 4:
                    for (Account acc: accountList) {
                        display(acc);
                    }
                    break;

                case 5:
                    System.out.println("Enter the account id need add money: ");
                    long addID = scanner.nextLong();
                    Account b = accountManagement.searchByID(addID);
                    if ( b == null ){
                        break;
                    }
                    System.out.println("Enter the money need add: ");
                    double numberMoney = scanner.nextDouble();
                        if(numberMoney<10000){
                            System.out.println("Illegal!");
                        }else {
                            b.addMoney(numberMoney);
                            System.out.println("Successful Implementation");
                        }
                        break;
                case 6:
                    System.out.println("Enter the account id need withdraw money: ");
                    long withDrawMoney = scanner.nextLong();
                    Account c = accountManagement.searchByID(withDrawMoney);
                    if ( c == null ){
                        break;
                    }
                    System.out.println("Enter the money need withdraw: ");
                    double x = scanner.nextDouble();
                    if(x>c.getAmount()){
                        System.out.println("Illegal!");
                    }else{
                        c.withdraw(x);
                        System.out.println("Successful Implementation");
                    }
                    break;
                case 7:
                    System.out.println("Enter the account id need transfer money: ");
                    long transferMoney = scanner.nextLong();
                    Account account1 = accountManagement.searchByID(transferMoney);
                    System.out.println("Enter the account id to receive money");
                    long getMoney = scanner.nextLong();
                    Account account2 = accountManagement.searchByID(getMoney);
                    System.out.println("Enter the money need transfer: ");
                    double y = scanner.nextDouble();
                    if(account1==null || account2==null){
                        break;
                    }else if(y>account2.getAmount()){
                        System.out.println("Illegal!");
                    }else{
                        account1.transfer(y,account2);
                        System.out.println("Successful Implementation");
                    }
                    break;
                case 8:
                    showMenu();
                    break;
                case 9:
                    System.out.println("GoodBye~~~");
                    return;
                default:
                    System.err.println("Error");
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

