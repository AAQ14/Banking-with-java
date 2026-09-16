package com.ga.bank;

import java.io.IOException;

public class Account{
    public double balance;
    public String accountType;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Account(String accountType){
        balance = 0;
        this.accountType = accountType;
    }

    public String toString(){
        return "ACCOUNT" + ","+
                getAccountType() + ","
                + getBalance();
    }
}
