package com.donbilly;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double bankBalance = 0;
    private String accountName;
    private String accountNumber;
    //create lock
    private Lock lock;

    public BankAccount(String accountName, String accountNumber, double initialBalance) {
        //initial balance is $1000.00
        this.bankBalance += initialBalance;
        this.accountName = accountName;
        this.accountNumber = accountNumber;

        //initialize lock
        this.lock = new ReentrantLock();
    }

    //method 1 - deposit
    public void deposit(String depositor, double depositAmount, String color){
        try{
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    //critical section
                    this.bankBalance += depositAmount;
                    System.out.println(color + depositor + " deposited "+ depositAmount +
                            " into A/C no: " + this.accountNumber + ", balance: "+
                            this.bankBalance);
                }finally{
                    //unlock critical section
                    lock.unlock();
                }
            }else {
                System.out.println("Could not get the lock");
            }

        }catch (InterruptedException e){
            //tryLock can throw InterruptedException
            //do something here
        }

    }

    //method 2 - withdraw
    public void withdraw(String withdrawer, double withdrawalAmount, String color){
        try{
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    //critical section
                    this.bankBalance -= withdrawalAmount;
                    System.out.println(color + withdrawer + " withdrawn "+ withdrawalAmount + " from A/C no: " +
                            this.accountNumber + ", balance: "+ this.bankBalance);
                }finally{
                    //unlock critical section
                    lock.unlock();
                }
            }else{
                System.out.println("Could not get the lock");
            }
        }catch(InterruptedException e){
            //tryLock can throw InterruptedException
            //do something here
        }
    }

    //get bank balance
    public double getBankBalance() {
        return bankBalance;
    }

    //get account name
    public String getAccountName() {
        return accountName;
    }

    //get account number
    public String getAccountNumber() {
        return accountNumber;
    }
}
