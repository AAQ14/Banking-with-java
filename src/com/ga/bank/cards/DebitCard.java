package com.ga.bank.cards;

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

    //Mutator methods

    public void setDepositLimitPerDay(double depositLimitPerDay) {
        this.depositLimitPerDay = depositLimitPerDay;
    }

    public void setDepositLimit(double depositLimit) {
        this.depositLimit = depositLimit;
    }

    public void setTransferLimitPerDay(double transferLimitPerDay) {
        this.transferLimitPerDay = transferLimitPerDay;
    }

    public void setTransferLimit(double transferLimit) {
        this.transferLimit = transferLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
