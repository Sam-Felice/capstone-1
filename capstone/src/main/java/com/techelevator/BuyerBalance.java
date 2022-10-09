package com.techelevator;

import java.math.BigDecimal;

public class BuyerBalance {
    //declaration
    private BigDecimal balance = new BigDecimal(0.00);

    //constructor
    public BuyerBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BuyerBalance(){}

    //getter and setter
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    //methods
    public void displayBalance(){
        System.out.println("Current money provided: $" +balance);
    }
    public BigDecimal addMoneyToBalance(BigDecimal amountToAdd){

        balance=balance.add(amountToAdd);
        return balance;
    }
    public BigDecimal takeMoneyForPurchase(BigDecimal price){
        balance=balance.subtract(price);
        return balance;
    }
}
