package com.ga.bank;

import com.ga.bank.cards.DebitCard;

public interface IAccount {
    double getBalance();
    int getAccountId();
    String getAccountType();
    boolean isActive();
    DebitCard getCard();
}
