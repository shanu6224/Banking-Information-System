package com.mycompany.bankinginformationsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingInformationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Account> accounts =
                new ArrayList<>();

        int accountNo = 1001;

        while(true) {

            System.out.println(
                    "\n===== BANKING SYSTEM =====");

            System.out.println("1. Register");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Fund Transfer");
            System.out.println("5. Account Statement");
            System.out.println("6. View Account Details");
            System.out.println("7. Update Account");
            System.out.println("8. Exit");

            System.out.print(
                    "Enter Choice : ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    sc.nextLine();

                    System.out.print(
                            "Enter Name : ");
                    String name =
                            sc.nextLine();

                    System.out.print(
                            "Enter Address : ");
                    String address =
                            sc.nextLine();

                    System.out.print(
                            "Enter Contact : ");
                    String contact =
                            sc.nextLine();

                    System.out.print(
                            "Create Password : ");
                    String password =
                            sc.nextLine();

                    System.out.print(
                            "Initial Deposit : ");

                    double balance =
                            sc.nextDouble();

                    Account acc =
                            new Account(
                                    accountNo++,
                                    name,
                                    address,
                                    contact,
                                    password,
                                    balance);

                    accounts.add(acc);

                    System.out.println(
                            "\nRegistration Successful");

                    System.out.println(
                            "Account Number : "
                                    + acc.accountNumber);

                    break;

                case 2:

                    System.out.print(
                            "Account Number : ");

                    int depAcc =
                            sc.nextInt();

                    boolean found =
                            false;

                    for(Account a :
                            accounts) {

                        if(a.accountNumber
                                == depAcc) {

                            found = true;

                            System.out.print(
                                    "Amount : ");

                            double amt =
                                    sc.nextDouble();

                            if(amt <= 0) {

                                System.out.println(
                                        "Invalid Amount");
                            }
                            else {

                                a.deposit(amt);

                                System.out.println(
                                        "Deposit Successful");

                                System.out.println(
                                        "Balance : Rs."
                                                + a.balance);
                            }
                        }
                    }

                    if(!found)
                        System.out.println(
                                "Account Not Found");

                    break;

                case 3:

                    System.out.print(
                            "Account Number : ");

                    int wAcc =
                            sc.nextInt();

                    found = false;

                    for(Account a :
                            accounts) {

                        if(a.accountNumber
                                == wAcc) {

                            found = true;

                            System.out.print(
                                    "Password : ");

                            String pass =
                                    sc.next();

                            if(!a.password
                                    .equals(pass)) {

                                System.out.println(
                                        "Wrong Password");

                                break;
                            }

                            System.out.print(
                                    "Amount : ");

                            double amt =
                                    sc.nextDouble();

                            if(a.withdraw(amt)) {

                                System.out.println(
                                        "Withdrawal Successful");

                                System.out.println(
                                        "Balance : Rs."
                                                + a.balance);
                            }
                            else {

                                System.out.println(
                                        "Insufficient Balance");
                            }
                        }
                    }

                    if(!found)
                        System.out.println(
                                "Account Not Found");

                    break;

                case 4:

                    System.out.print(
                            "Sender Account : ");

                    int sender =
                            sc.nextInt();

                    System.out.print(
                            "Receiver Account : ");

                    int receiver =
                            sc.nextInt();

                    System.out.print(
                            "Amount : ");

                    double transfer =
                            sc.nextDouble();

                    Account senderAcc =
                            null;

                    Account receiverAcc =
                            null;

                    for(Account a :
                            accounts) {

                        if(a.accountNumber
                                == sender)
                            senderAcc = a;

                        if(a.accountNumber
                                == receiver)
                            receiverAcc = a;
                    }

                    if(senderAcc == null
                            || receiverAcc == null) {

                        System.out.println(
                                "Invalid Account");
                    }

                    else if(senderAcc.balance
                            < transfer) {

                        System.out.println(
                                "Insufficient Balance");
                    }

                    else {

                        senderAcc.balance
                                -= transfer;

                        receiverAcc.balance
                                += transfer;

                        senderAcc.transactions.add(
                                "Transfer Sent Rs."
                                        + transfer);

                        receiverAcc.transactions.add(
                                "Transfer Received Rs."
                                        + transfer);

                        System.out.println(
                                "Transfer Successful");
                    }

                    break;

                case 5:

                    System.out.print(
                            "Account Number : ");

                    int stmtAcc =
                            sc.nextInt();

                    found = false;

                    for(Account a :
                            accounts) {

                        if(a.accountNumber
                                == stmtAcc) {

                            found = true;

                            System.out.print(
                                    "Password : ");

                            String pass =
                                    sc.next();

                            if(!a.password
                                    .equals(pass)) {

                                System.out.println(
                                        "Wrong Password");

                                break;
                            }

                            System.out.println(
                                    "\n===== ACCOUNT STATEMENT =====");

                            for(String t :
                                    a.transactions) {

                                System.out.println(
                                        t);
                            }

                            System.out.println(
                                    "Current Balance : Rs."
                                            + a.balance);
                        }
                    }

                    if(!found)
                        System.out.println(
                                "Account Not Found");

                    break;

                case 6:

                    System.out.print(
                            "Account Number : ");

                    int viewAcc =
                            sc.nextInt();

                    boolean foundAcc =
                            false;

                    for(Account a :
                            accounts) {

                        if(a.accountNumber
                                == viewAcc) {

                            foundAcc = true;

                            System.out.println(
                                    "\nACCOUNT DETAILS");

                            System.out.println(
                                    "Account No : "
                                            + a.accountNumber);

                            System.out.println(
                                    "Name : "
                                            + a.name);

                            System.out.println(
                                    "Address : "
                                            + a.address);

                            System.out.println(
                                    "Contact : "
                                            + a.contact);

                            System.out.println(
                                    "Balance : Rs."
                                            + a.balance);
                        }
                    }

                    if(!foundAcc)
                        System.out.println(
                                "Account Not Found");

                    break;

                case 7:

                    System.out.print(
                            "Account Number : ");

                    int updAcc =
                            sc.nextInt();

                    sc.nextLine();

                    boolean updated =
                            false;

                    for(Account a :
                            accounts) {

                        if(a.accountNumber
                                == updAcc) {

                            updated = true;

                            System.out.print(
                                    "New Name : ");

                            a.name =
                                    sc.nextLine();

                            System.out.print(
                                    "New Address : ");

                            a.address =
                                    sc.nextLine();

                            System.out.print(
                                    "New Contact : ");

                            a.contact =
                                    sc.nextLine();

                            System.out.println(
                                    "Account Updated Successfully");
                        }
                    }

                    if(!updated)
                        System.out.println(
                                "Account Not Found");

                    break;

                case 8:

                    System.out.println(
                            "Thank You");

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }
}