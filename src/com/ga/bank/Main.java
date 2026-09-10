package com.ga.bank;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {
//    public static Account account;
//    public static String username;
//    public static String userType
        public static Scanner scanner;
//
//    public static int id;
    public Main(){
//        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
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

        }else if(reply == 3){
            scanner.close();
        }
    }

    public static void createFile(String userType, String userName, int id)
    {
        try{
              File myObj = new File(userType + "-" + userName +"-" + id +".txt");
//            File myObj = new File(userType + "-" + username +"-" + id +".txt");
            if (myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }
            else{
                System.out.println("File already exits.");
            }

        }catch(IOException e){
            System.out.println("An error occured.");
            e.printStackTrace(); //print the error details
        }
    }

    public static void signUp(){
        int id; String firstName; String lastName; String userName; String email; String password; Object userType;
        id = 9;
        System.out.println("Enter first name: ");
        firstName = scanner.next();
        System.out.println("Enter last name: ");
        lastName = scanner.next();
        System.out.println("Enter username: ");
        userName = scanner.next();
        System.out.println("Enter email: ");
        email = scanner.next();
        System.out.println("Create password: ");
        password = scanner.next();
        System.out.println("Enter user type: ");
        userType = scanner.next();

        Account account = new Account(firstName, lastName,  userName,  email,  password,  userType, 0);
        createFile(account.user.userType.toString(), account.user.userName, account.user.id );
    }
}
