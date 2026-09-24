package com.ga.tdd;

import com.ga.bank.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.io.IOException;

public class TransactionsTest {

    Customer customer1;
    Customer customer2;
    Account account1;
    Account account2;

    @Before
    public void setUp() throws IOException {
        customer1 = new Customer("moh'd", "ali", "m_a", "m@gmail.com", "123", "C");
        customer2 = new Customer("ali", "moh'd", "a_m", "a@gmail.com", "123", "C");
        new Transactions(customer1);
        FileManager.createFile("C", "m_a", 00034);
        FileManager.createFile("C", "a_m", 00035);
        account1 = new Account("checking");
        account1.setBalance(200);
        account2 = new Account("savings");
        account2.setBalance(500);
    }

    @Test
    public void deposit() throws IOException {
        Transactions.deposit(account1, 100);
        Assert.assertEquals(200+100, account1.getBalance(), 0.001);
    }

    @Test
    public void withdrawal() throws IOException {
        Transactions.withdrawal(account1, 10);
        Assert.assertEquals(200-10, account1.getBalance(), 0.001);
    }

    @Test
    public void transfer() throws IOException {
        Transactions.transfer(customer1, account1, customer2,account2,40);
        Assert.assertEquals(200-40, account1.getBalance(), 0.001);
        Assert.assertEquals(500+40, account2.getBalance(), 0.001);
    }
}