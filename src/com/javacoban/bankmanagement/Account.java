package com.javacoban.bankmanagement;

// chứa thông tin của account
//final : interest: float = 0.035
//        +  ID : long
//        + accountName: String
//        + amount: double
//
//        Constructor( 2), Constructor: So tai khoan, ten tai khoan . Amount = 50000
//        Get/Set
//        toString: String
//

public class Account {
    public static final float INTEREST = 0.035f;

    private long ID;
    private String accountName;
    private double amount;

    public Account(long ID, String accountName, double amount) {
        this.ID = ID;
        this.accountName = accountName;
        this.amount = amount;
    }

    public Account() {}

    public Account(long ID, String accountName) {
        this.accountName = accountName;
        this.ID = ID;
        this.amount = 50000;
    }
    public void addMoney(double amountMoney) {

        this.amount  += amountMoney;
    }

    public void withdraw(double amountWithdraw) {

        this.amount -= amountWithdraw;
    }

    public void expires() {

        this.amount = this.amount + this.amount * INTEREST;
    }

    public void transfer(double amount, Account account ) {
        this.amount = this.amount - amount;
        double newAmount = account.getAmount() + amount;
        account.setAmount(newAmount);
    }

    public long getID() {

        return ID;
    }

    public void setID(long ID) {

        this.ID = ID;
    }

    public String getAccountName() {

        return accountName;
    }

    public void setAccountName(String accountName) {

        this.accountName = accountName;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    public String toString() {
        return "[ID: " + ID + ", accountName: "  + accountName + ", amount: " + amount + "]";

        // [ID: 1, accountName: hauvu, amount: 10000000]
    }
}
