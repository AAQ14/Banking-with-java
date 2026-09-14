package com.ga.bank;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class Transactions {
    public User user;
    public double balance;
    public String from;
    public String to;
    public Date date;
    public Time time;
    public static Scanner scanner = new Scanner(System.in);



    public Transactions(User user) {
        this.user = user;
        balance = user.getAmount();
    }

    public void deposit(double amount){

    }

    public static void services(Customer user){
        System.out.println("choose services");
        System.out.println("1. create an account");
        System.out.println("2. deposit");
        System.out.println("3. withdraw");
        System.out.println("4. transfer");
        int service = scanner.nextInt();
        if(service == 1){
            System.out.println("Select the account you want to create: ");
            System.out.println("1. Saving account");
            System.out.println("2. Checking account");
            int accountSelected = scanner.nextInt();
            if(accountSelected ==1){
                Account account = new Account("Saving account");
                user.accounts.add(account);
            }else if(accountSelected==2){
                Account account = new Account("Checking account");
                user.accounts.add(account);
            }
        }else if(service == 2){
            System.out.println("from which account you want to deposit");
//            System.out.println();
        }
    }


}
