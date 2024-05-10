package com.example.jay_bank.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Transaction {
    private final StringProperty sender;
    private final StringProperty recipient;
    private final DoubleProperty amount;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty description;

    public Transaction(String sender, String recipient, Double amount, LocalDate date, String description) {
        this.sender = new SimpleStringProperty(this, "Sender", sender);
        this.recipient = new SimpleStringProperty(this, "Recipient", recipient);
        this.amount = new SimpleDoubleProperty(this, "Amount", amount);
        this.date = new SimpleObjectProperty<>(this, "Date", date);
        this.description = new SimpleStringProperty(this, "Description", description);
    }

    public StringProperty senderProperty() {return sender;}

    public StringProperty recipientProperty() {return recipient;}

    public DoubleProperty amountProperty() {return amount;}

    public ObjectProperty<LocalDate> dateProperty() {return date;}

    public StringProperty descriptionProperty() {return description;}
}
