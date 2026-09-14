package com.ga.bank;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.security.MessageDigest;
import java.util.stream.Stream;


public class Main {

        public static Scanner scanner;
        public static Auth auth;

    public Main(){
        auth = new Auth();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the bank service system");
        System.out.println("1. Sign up");
        System.out.println("2. Login");
        System.out.println("3. exit");
        System.out.println("Enter the choice");

        int reply = scanner.nextInt();
        if(reply ==1 ){
         auth.signUp();
        }else if(reply == 2){
            auth.signIn();
        }else if(reply == 3){
            scanner.close();
        }

    }


}
