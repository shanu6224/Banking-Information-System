package com.mycompany.bankinginformationsystem;

public class Transaction {

    String type;
    double amount;

    public Transaction(String type, double amount) {

        this.type = type;
        this.amount = amount;
    }

    public void display() {

        System.out.println(
                type + " : Rs." + amount);
    }
}