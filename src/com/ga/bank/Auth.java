package com.ga.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Auth {
    public static Scanner scanner= new Scanner(System.in);
    public static FileManager fm;
    public static Customer customer;
    public static Banker banker;

    public Auth(){
        scanner = new Scanner(System.in);
        fm = new FileManager();
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
            User.readLastId();
            customer = new Customer(firstName, lastName, userName, email, password, userType);
            FileManager.createFile(customer.getUserType(), customer.getUserName(), customer.getId());
            FileManager.addingData(customer);
        }else if (userType.equals("B")) {
            User.readLastId();
            banker = new Banker(firstName, lastName, userName, email, password, userType);
            FileManager.createFile(banker.getUserType(), banker.getUserName(), banker.getId());
            FileManager.addingData(banker);
        }


    }

    public static User signIn() throws IOException, NoSuchAlgorithmException {
        String username; String pass; User user =null;
        System.out.println("Enter username: ");
        username = scanner.next();
        System.out.println("Enter password: ");
        pass = scanner.next();

        FileReader fr = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);

//        Stream<String> lines = br.lines();
//        System.out.println("test");
//        lines.forEach(System.out::println);
        String line = br.readLine();
        String cryptPass = cryptographic(pass);

        while(line!=null){
            String[] data = line.split(",");
            if(Objects.equals(data[3], username) && Objects.equals(data[5], cryptPass)){
                //find the user with the same username and assign it to the user
                if(data[6].equals("C")){
                    user = new Customer(data[1], data[2], data[3], data[4], data[5], data[6]);
                    System.out.println(username + " logged in");
                    Services.services((Customer) user);
                } else if (data[6].equals("B")) {
                    user = new Banker(data[1], data[2], data[3], data[4], data[5], data[6]);
                }
                System.out.println(username + " logged in");
//                services(user);
            }
            line = br.readLine();
        }
        if(user==null)
            System.out.println("login failed");

        System.out.println("this is the user details that signed"+user.toString());
        return user;
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
