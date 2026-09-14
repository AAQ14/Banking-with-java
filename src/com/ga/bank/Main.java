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
        String firstName; String lastName; String userName; String email; String password; String userType;
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
        System.out.println(userType);

        if(userType.equals("C")){
            Customer user = new Customer(firstName, lastName, userName, email, password, userType, 0);
            System.out.println(user);
            System.out.println("user type: " + user.getUserType() + ",  username: " + user.getUserName() + ",  user id: " +user.getId());
            createFile(user.getUserType(), user.getUserName(), user.getId());
            addingData(user);
        }else if (userType.equals("B")) {
            Banker user = new Banker(firstName, lastName, userName, email, password, userType, 0);
            System.out.println(user);
            createFile(user.getUserType(), user.getUserName(), user.getId());
            addingData(user);
        }


    }

    public static void signIn() throws IOException, NoSuchAlgorithmException {
        String username; String pass;
        System.out.println("Enter username: ");
        username = scanner.next();
        System.out.println("Enter password: ");
        pass = scanner.next();

        FileReader fr = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);

        Stream<String> lines = br.lines();
        System.out.println("test");
        lines.forEach(System.out::println);
        String line = br.readLine();

        while(line!=null){
            String[] data = line.split(",");
            String cryptPass = cryptographic(pass);
            if(Objects.equals(data[3], username) && Objects.equals(data[5], cryptPass)){
                //find the user with the same username and assign it to the user

                System.out.println(username + " logged in");
//                services(user);
            }else{
                System.out.println("username or password are incorrect");
            }
            line = br.readLine();
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
    public static void addingData(Object account) throws IOException {
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
