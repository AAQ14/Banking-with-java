package com.ga.bank;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    public String type;
    public double balance;
    public double amount;
    public String from;
    public String to;
    public LocalDate date;
    public LocalTime time;

    public Transaction(String type, double balance,  double amount, String from, String to, LocalDate date, LocalTime time){
        this.type = type;
        this.balance = balance;
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
    }
}
