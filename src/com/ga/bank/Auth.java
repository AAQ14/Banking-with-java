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
    public static Scanner scanner = new Scanner(System.in);

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
            UserFileManager.createFile(user.getUserType(), user.getUserName(), user.getId());
            UserFileManager.addingData(user);
        }else if (userType.equals("B")) {
            Banker user = new Banker(firstName, lastName, userName, email, password, userType, 0);
            System.out.println(user);
            UserFileManager.createFile(user.getUserType(), user.getUserName(), user.getId());
            UserFileManager.addingData(user);
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

//        Stream<String> lines = br.lines();
//        System.out.println("test");
//        lines.forEach(System.out::println);
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
