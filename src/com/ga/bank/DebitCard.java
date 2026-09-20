package com.ga.bank;

public abstract class DebitCard {
    //Debit card fields
    public double withdrawLimit;
    public double transferLimit;
    public double transferLimitPerDay;
    public double depositLimit;
    public double depositLimitPerDay;

    public DebitCard(double depositLimitPerDay, double depositLimit, double transferLimitPerDay, double transferLimit, double withdrawLimit) {
        this.depositLimitPerDay = depositLimitPerDay;
        this.depositLimit = depositLimit;
        this.transferLimitPerDay = transferLimitPerDay;
        this.transferLimit = transferLimit;
        this.withdrawLimit = withdrawLimit;
    }

    //Accessor methods
    public abstract double getWithdrawLimit();

    public abstract double getTransferLimit();

    public abstract double getTransferLimitPerDay();

    public abstract double getDepositLimit();

    public abstract double getDepositLimitPerDay();

}
