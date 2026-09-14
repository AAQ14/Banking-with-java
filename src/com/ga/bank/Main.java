package com.ga.bank;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.security.MessageDigest;
import java.util.stream.Stream;

import static com.ga.bank.Auth.signIn;
import static com.ga.bank.Auth.signUp;


public class Main {

        public static Scanner scanner;

    public Main(){
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        File myObj = new File("../data.txt");
        if(myObj.exists()){
            System.out.println("file size in bytes " + myObj.toURI());
        }



        FileWriter fw = new FileWriter("../data.txt", true);
        System.out.println(fw);
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the bank service system");
        System.out.println("1. Sign up");
        System.out.println("2. Login");
        System.out.println("3. exit");
        System.out.println("Enter the choice");

        int reply = scanner.nextInt();
        if(reply ==1 ){
         signUp();
        }else if(reply == 2){
            signIn();
        }else if(reply == 3){
            scanner.close();
        }
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
