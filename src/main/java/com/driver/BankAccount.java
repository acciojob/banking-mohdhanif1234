package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        int totalSum = 0;
        int temp = digits;
        while(temp > 0){
            totalSum += (temp % 10);
            temp /= 10;
        }
        if(totalSum != sum){
            throw new Exception("Account Number can not be generated");
        }
        else if(totalSum == sum){
            return Integer.toString(totalSum);
        }
        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        double remAmount = balance - amount;
        if(remAmount > 0 && remAmount < minBalance){
            String str = "Insufficient Balance";
            throw new Exception(str);
        }
        this.balance -= amount;
    }

}