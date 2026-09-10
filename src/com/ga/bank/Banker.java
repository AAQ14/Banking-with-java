package com.ga.bank;

public class Banker extends User{


    public Banker(String firstName, String lastName, String userName, String email, String password, Object userType, double amount) {
        super(firstName, lastName, userName, email, password, userType, amount);
    }

    @Override
    public int gerID() {
        return 0;
    }
}
