package com.ga.bank;

public class Banker extends User{


    public Banker(String firstName, String lastName, String userName, String email, String password, Object userType, double amount) {
        super(firstName, lastName, userName, email, password, userType, amount);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getFirstName() {
        return "";
    }

    @Override
    public String getLastName() {
        return "";
    }

    @Override
    public String getUserName() {
        return "";
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUserType() {
        return "";
    }

    @Override
    public double getAmount() {
        return 0;
    }

    @Override
    public int getId() {
        return 0;
    }
}
