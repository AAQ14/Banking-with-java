package com.ga.bank;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import java.util.Optional;

public class Transactions {
    public User user;
    public double balance;
    public String from;
    public String to;
    public Date date;
    public Time time;
    public static Customer customer;
    public static Scanner scanner = new Scanner(System.in);



    public Transactions(User user) {
        this.user = user;
    }

    public void deposit(double amount){

    }

    public static void services(Customer user) throws IOException {
        customer = user;
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
                System.out.println(customer.accounts);
                Optional<Account> account1= customer.accounts.stream().filter(account -> account.accountType.equals("Saving")).findFirst();

                account1.ifPresentOrElse((account)->System.out.println("u already have " + account +""),()->{
                    Account account = new Account("Saving");
                    customer.accounts.add(account);
                });

            }else if(accountSelected==2){
                Account account = new Account("Checking account");
                customer.accounts.add(account);
            }
        }else if(service == 2){
            System.out.println("from which account you want to deposit");
//            System.out.println();
        }
    }


    public void deposit(Account account1, Account account2){

    }

    public void withdrawal(Account account1, Account account2){

    }

    public void transfer(User user1,  Account account1, User user2, Account account2){

    }

}
