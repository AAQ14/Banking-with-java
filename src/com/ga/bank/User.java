package com.ga.bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public abstract class User {
    public int id;
    public String firstName;
    public String lastName;
    public String userName;
    public String email;
    public String password;
    public String userType;
    //would it be preferable to make it static or?
    public double amount;
    public static AtomicInteger num = new AtomicInteger(0);;

//    protected abstract User();


    public User(String firstName, String lastName, String userName, String email, String password, String userType, double amount) throws IOException {
        readLastId();
        num.incrementAndGet();
        this.id = num.intValue();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.amount = amount;
    }

    public abstract int getId();

    public abstract String getFirstName();

    public abstract String getLastName();

    public abstract String getUserName();

    public abstract String getEmail();

    public abstract String getPassword();

    public abstract String getUserType();

    public abstract double getAmount();

    @Override
    public String toString() {
        return
                String.format("%05d", getId()) + ","+
                getFirstName() + "," +
                getLastName() + "," +
                getUserName() + "," +
                getEmail() + "," +
                getPassword() + "," +
                getUserType() + "," +
                getAmount();
    }


    public static void readLastId() throws IOException {
        FileReader fr = new FileReader("data.txt");

        BufferedReader br = new BufferedReader(fr);
//        Stream<String> stream = Files.lines(Path.of("data.txt"));
//        stream.forEach(System.out::println);
        String line = br.readLine();
        String lastLine = null;

        while(line!=null){
            System.out.println(line);
            lastLine = line;
            System.out.println("this is that last line: " + lastLine);
            line= br.readLine();
        }

        if(lastLine!=null){
            String[] parts = lastLine.split(",");
            num.set(Integer.parseInt(parts[0]));
        }

        br.close();
    }
}

