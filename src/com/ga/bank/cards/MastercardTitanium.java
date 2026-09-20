package com.ga.bank.cards;

public class MastercardTitanium extends DebitCard{

    //Mastercard Titanium constructor
    public MastercardTitanium(double depositLimitPerDay, double depositLimit, double transferLimitPerDay, double transferLimit, double withdrawLimit) {
        super(depositLimitPerDay, depositLimit, transferLimitPerDay, transferLimit, withdrawLimit);
    }

    //Override accessor methods
    @Override
    public double getWithdrawLimit() {
        return this.withdrawLimit;
    }

    @Override
    public double getTransferLimit() {
        return this.transferLimit;
    }

    @Override
    public double getTransferLimitPerDay() {
        return this.transferLimitPerDay;
    }

    @Override
    public double getDepositLimit() {
        return this.depositLimit;
    }

    @Override
    public double getDepositLimitPerDay() {
        return this.depositLimitPerDay;
    }

    //Override mutator methods
    @Override
    public void setDepositLimitPerDay(double depositLimitPerDay) {
        super.setDepositLimitPerDay(depositLimitPerDay);
    }

    @Override
    public void setDepositLimit(double depositLimit) {
        super.setDepositLimit(depositLimit);
    }

    @Override
    public void setTransferLimitPerDay(double transferLimitPerDay) {
        super.setTransferLimitPerDay(transferLimitPerDay);
    }

    @Override
    public void setTransferLimit(double transferLimit) {
        super.setTransferLimit(transferLimit);
    }

    @Override
    public void setWithdrawLimit(double withdrawLimit) {
        super.setWithdrawLimit(withdrawLimit);
    }
}
