package com.ga.bank;

import java.sql.Time;
import java.util.Date;

public class Transactions {
    public User user;
    public double balance;
    public String from;
    public String to;
    public Date date;
    public Time time;



    public Transactions(User user) {
        this.user = user;
        balance = user.getAmount();
    }

    public void deposit(double amount){

    }



}
