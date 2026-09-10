package com.ga.bank;

public abstract class User {
    public static int id;
    public static String firstName;
    public static String lastName;
    public static String userName;
    public static String email;
    public static String password;
    public static Object userType;
    //would it be preferable to make it static or?
    public double amount;

//    protected abstract User();

    public User(String firstName, String lastName, String userName, String email, String password, Object userType, double amount) {
        User.firstName = firstName;
        User.lastName = lastName;
        User.userName = userName;
        User.email = email;
        User.password = password;
        User.userType = userType;
        //
        this.amount = amount;
    }



    public abstract int gerID();

    public static int getID() {
        return id;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        User.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        User.lastName = lastName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static Object getUserType() {
        return userType;
    }

    public static void setUserType(Object userType) {
        User.userType = userType;
    }

    public double getAmount() {
        return amount;
    }

    public  void setAmount(double amount) {
        this.amount = amount;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        User.userName = userName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }
}

