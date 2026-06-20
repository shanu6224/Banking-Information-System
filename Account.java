package com.mycompany.bankinginformationsystem;

import java.util.ArrayList;

public class Account {

    int accountNumber;
    String name;
    String address;
    String contact;
    String password;
    double balance;

    ArrayList<String> transactions = new ArrayList<>();

    public Account(int accountNumber,
                   String name,
                   String address,
                   String contact,
                   String password,
                   double balance) {

        this.accountNumber = accountNumber;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.password = password;
        this.balance = balance;

        transactions.add("Account Opened : Rs." + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposit : Rs." + amount +
                " Balance : Rs." + balance);
    }

    public boolean withdraw(double amount) {

        if(balance >= amount) {

            balance -= amount;

            transactions.add("Withdraw : Rs." + amount +
                    " Balance : Rs." + balance);

            return true;
        }

        return false;
    }
}