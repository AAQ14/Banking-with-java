package com.ga.bank;

public class Account extends User {
    boolean isAvailable;

    public Account(String firstName, String lastName, String userName, String email, String password, Object userType, double amount) {
        super(firstName, lastName, userName, email, password, userType, amount);
    }


    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUserType() {
        return userType.toString();
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public int getId() {
        return id;
    }



}
