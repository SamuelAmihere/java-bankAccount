package com.donbilly;
public class Main {
    /*
    Challenge1: Create and Start Thread
    We could have two people using a joint account at the same time.
    Create and start two threads that use the same BankAccount instance
    and an initial balance of $1000.00. One will deposit $300.00 into the
    bank account, and then withdraw $50.00. The other will deposit $203.75
    and then withdraw $100.00.

    Instead of using lock(), use tryLock() with a timeout value of 1 sec. If the
    waiting period times out, print the message, "Could not get the lock" to the
    console.

    Hint:
    Use the form of the tryLock() method that accepts two parameters - the
    first parameter is the timeout value, and the second parameter is the time
    unit of the first parameter. Use TimeUnit.MILLISECONDS for the second parameter.

    */

    public static String accountType =  "Savings";
    public static String accountNumber = "12345-6789";
    public static double initialBalance = 1000.00;
    public static String customer1 = "Samuel";
    public static String customer2 = "Rebecca";
    public static double depositAmount;
    public static double withdrawalAmount;

    public static void main(String[] args) {

        //Create account
        BankAccount bankAccount = new BankAccount(accountType, accountNumber,initialBalance);

        //Create Threads to perform deposits and withdrawals
        new Thread(new DepositWithdraw(bankAccount, 300.00,50,"Samuel")).start();
        new Thread(new DepositWithdraw(bankAccount, 203.75,100.00,"Rebecca")).start();

    }
}