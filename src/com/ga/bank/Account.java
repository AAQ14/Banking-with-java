package com.ga.bank;

public class Account extends User {
    public User user;
    boolean isAvailable;

    public Account(String firstName, String lastName, String userName, String email, String password, Object userType, double amount) {
        super(firstName, lastName, userName, email, password, userType, amount);
    }


    @Override
    public int gerID() {
        return 0;
    }
}
