package com.ga.bank;

import java.io.IOException;

public class Account{
    public boolean isExists;
    public double balance;
    public String accountType;

    public Account(String accountType){
        isExists = true;
        balance = 0;
        this.accountType = accountType;
    }

}
