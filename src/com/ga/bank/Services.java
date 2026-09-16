package com.ga.bank;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class Services {

    public static Scanner scanner = new Scanner(System.in);

    public static void services(Customer user) throws IOException {
        Customer customer = user;
        System.out.println("choose services");
        System.out.println("1. create an account");
        System.out.println("2. deposit");
        System.out.println("3. withdraw");
        System.out.println("4. transfer");
        int service = scanner.nextInt();
        if (service == 1) {
            System.out.println("Select the account you want to create: ");
            System.out.println("1. Saving account");
            System.out.println("2. Checking account");
            int accountSelected = scanner.nextInt();
            if (accountSelected == 1) {
                System.out.println(customer.accounts);
                customer.createAccount("Saving");
            } else if (accountSelected == 2) {
                System.out.println(customer.accounts);
                customer.createAccount("Checking");
            }
        } else if (service == 2) {
            Transactions transactions = new Transactions(customer);
            System.out.println("in which account you want to deposit");
            System.out.println("1. Saving account");
            System.out.println("2. Checking account");
            int accountSelected = scanner.nextInt();
            if (accountSelected == 1) {
                System.out.println("how much do u want to deposit");
                double amount = scanner.nextDouble();
                Optional<Account> selectedAccount = customer.accounts.stream().filter(a -> a.accountType.equals("Saving")).findFirst();
                if (selectedAccount.isPresent()) {
                    System.out.println(customer.accounts);
                    transactions.deposit(selectedAccount.get(), amount);
                }
            } else if (accountSelected == 2) {
                System.out.println("how much do u want to withdraw");
                double amount = scanner.nextDouble();
                Optional<Account> selectedAccount = customer.accounts.stream().filter(a -> a.accountType.equals("Checking")).findFirst();
                if (selectedAccount.isPresent()) {
                    System.out.println(customer.accounts);
                    transactions.deposit(selectedAccount.get(), amount);
                }
            }
        } else if (service == 3) {
            Transactions transactions = new Transactions(customer);
            System.out.println("in which account you want to withdraw");
            System.out.println("1. Saving account");
            System.out.println("2. Checking account");
            int accountSelected = scanner.nextInt();
            if (accountSelected == 1) {
                System.out.println("how much do u want to withdraw");
                double amount = scanner.nextDouble();
                Optional<Account> selectedAccount = customer.accounts.stream().filter(a -> a.accountType.equals("Saving")).findFirst();
                if (selectedAccount.isPresent()) {
                    System.out.println(customer.accounts);
                    transactions.withdrawal(selectedAccount.get(), amount);
                }
            } else if (accountSelected == 2) {
                System.out.println("how much do u want to withdraw");
                double amount = scanner.nextDouble();
                Optional<Account> selectedAccount = customer.accounts.stream().filter(a -> a.accountType.equals("Checking")).findFirst();
                if (selectedAccount.isPresent()) {
                    System.out.println(customer.accounts);
                    transactions.withdrawal(selectedAccount.get(), amount);
                }

            }

        }
    }

}