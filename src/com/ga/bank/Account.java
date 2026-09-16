package com.ga.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Account{
    public double balance;
    public String accountType;
    public int accountId;
    public static AtomicInteger num = new AtomicInteger(0);

    public Account(String accountType) throws IOException {
        num.incrementAndGet();
        accountId =  num.intValue();
        balance = 0;
        this.accountType = accountType;
    }

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



    public String toString(){
        return "ACCOUNT" + ","+
                getAccountType() + ","
                + getBalance();
    }

    public static void readLastAccountId() throws IOException{
        FileReader fr = new FileReader("accounts.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        String lastLine = null;

        while(line!=null){
            lastLine = line;
            line = br.readLine();
        }

        if(lastLine!=null){
            String[] data = line.split(",");
            num.set(Integer.parseInt(data[0]));
        }

        br.close();
    }
}
