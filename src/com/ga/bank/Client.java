package com.ga.bank;

public class Client extends User {


    public Client(String firstName, String lastName, String userName, String email, String password, Object userType, double amount) {
        super(firstName, lastName, userName, email, password, userType, amount);
    }

    @Override
    public int gerID() {
        return User.getID();
    }

}
