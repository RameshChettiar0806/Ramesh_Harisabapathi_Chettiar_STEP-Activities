package com.gdb.domain;
// Account.java from Activity 1
public class Account {
    // TODO: Step 1 - Declare the 6 private fields:
    // - accountNumber (String)
    private String accountNumber;
    // - name (String)
    private String name;
    // - age (int)
    private int age;
    // - balance (double)
    private double balance;
    // - accountType (String)
    private String accountType;
    // - status (String)
    private String status;

    public Account(String accountNumber, String name, int age, double balance, String accountType, String status) {
        // TODO: Step 2 - Initialize instance variables with parameters
        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.accountType = accountType;
        this.status = status;
    }

    public boolean deposit(double amount) {
        // TODO: Step 3 - Validate amount > 0, increase balance, and return true; return false otherwise
        if(amount > 0){
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        // TODO: Step 4 - Validate amount > 0 and balance >= amount, deduct from balance, and return true; return false otherwise
        if(amount > 0 && balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public void displayAccountInfo() {
        // TODO: Step 5 - Print formatted account information (AccountNumber, Name, Age, Balance, AccountType, Status)
        System.out.println("=========Account Information=========");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name of Customer: " + name);
        System.out.println("Age of Customer: " + age);
        System.out.println("Balance: INR." + balance);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Status: " + status);
    }

    // TODO: Step 6 - Declare public getters and setters for all private fields

    //Account Number
    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    // Name of Customer
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    // Age of Customer
    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    // Account Balance
    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    //Account Type
    public String getAccountType(){
        return accountType;
    }

    public void setAccountType(String accountType){
        this.accountType = accountType;
    }

    //Account Status
    public String getAccountStatus(){
        return status;
    }

    public void setAccountStatus(String status){
        this.status = status;
    }
}
