package com.ga.bank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class User {
    public int id;
    public String firstName;
    public String lastName;
    public String userName;
    public String email;
    public String password;
    public Object userType;
    //would it be preferable to make it static or?
    public double amount;
    public static AtomicInteger num = new AtomicInteger(0);;

//    protected abstract User();

    public static void main(String[] args) throws FileNotFoundException {
        readLastId();
    }
    public User(String firstName, String lastName, String userName, String email, String password, Object userType, double amount) {
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


    public abstract int getID();

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
                String.format("%05d", getID()) + ","+
                getFirstName() + "," +
                getLastName() + "," +
                getUserName() + "," +
                getEmail() + "," +
                getPassword() + "," +
                getUserType() + "," +
                getAmount();
    }

    public abstract int getId();

    public static void readLastId() throws FileNotFoundException {
        FileReader fr = new FileReader("../data.txt");

    }
}

