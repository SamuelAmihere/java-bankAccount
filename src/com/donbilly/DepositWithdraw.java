package com.donbilly;

public class DepositWithdraw implements Runnable {
    private BankAccount acc;
    private double depositAmount;
    private double withdrawalAmount;
    private String depositorName;

    public DepositWithdraw(BankAccount acc, double depositAmount, double withdrawalAmount, String depositorName) {
        this.acc = acc;
        this.depositorName = depositorName;
        this.depositAmount = depositAmount;
        this.withdrawalAmount = withdrawalAmount;
    }
    @Override
    public void run() {
        // deposit amount into the bank account
        acc.deposit(this.depositorName, this.depositAmount, ThreadColor.GREEN);
        // withdraw amount from bank account
        acc.withdraw(this.depositorName, this.withdrawalAmount, ThreadColor.PURPLE);
    }

}
