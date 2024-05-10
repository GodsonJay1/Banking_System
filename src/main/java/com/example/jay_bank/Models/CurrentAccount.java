package com.example.jay_bank.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CurrentAccount extends Account {

    // number of transactions per day
    private final IntegerProperty transactionLimit;

    public CurrentAccount(String owner, String accountNumber, double balance, int tLimit) {
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(this, "Transaction Limit", tLimit);
    }

    public IntegerProperty transactionLimitProperty() {return transactionLimit;}

    @Override
    public String toString() {
        return accountNumberProperty().get();
    }
}
