package com.ga.bank;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;
import java.security.MessageDigest;


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

    public static void signUp() throws IOException, NoSuchAlgorithmException {
        String firstName; String lastName; String userName; String email; String password; Object userType;
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
        password = cryptographic(password);
        System.out.println("Enter user type: ");
        userType = scanner.next();

        Account account = new Account(firstName, lastName, userName, email, password, userType, 0);
        createFile(account.getUserType(), account.getUserName(), account.getID());


        addingData(account);
    }

    public static void addingData(Account account) throws IOException {
        FileWriter fw = new FileWriter("data.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(account.toString());
        bw.newLine();

        bw.close();
        //System.out.println(account.getUser().toString());

    }

    public static String cryptographic(String pass) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] passBytes = pass.getBytes();
            md.update(passBytes);
            passBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i: passBytes){
                // i searched and found i have to keep iy
               sb.append(Integer.toHexString(i & 0xff));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException exception){
            System.err.println("Exception occurred: " + exception);
        }

        return "";
    }
}
