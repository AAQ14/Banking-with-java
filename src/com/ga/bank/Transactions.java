package com.ga.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;
import java.util.Optional;

public class Transactions {
//    public User user;

    public static Customer customer;
    public static Scanner scanner = new Scanner(System.in);
    public static FileReader fr;
    public static BufferedReader br;


//    public Transactions(User user) {
//        this.user = user;
//    }

    public Transactions(Customer customer){
        this.customer = customer;
    }

    public static void deposit(Account account, double amount) throws IOException {
            account.balance += amount;
            FileManager.updateAccounts(customer, account);
    }

    public void withdrawal(Account account1, Account account2){

    }

    public void transfer(User user1,  Account account1, User user2, Account account2){

    }

}
