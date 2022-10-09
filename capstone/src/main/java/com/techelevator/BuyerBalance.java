package com.techelevator;

import java.math.BigDecimal;

public class BuyerBalance {
    //declaration
    private BigDecimal balance = new BigDecimal(0.00);
    private int quarters = 0;
    private int dimes = 0;
    private int nickels = 0;

    //constructor
    public BuyerBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BuyerBalance() {
    }


    //getter and setter
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }


    //methods
    public void displayBalance() {
        System.out.println("Current money provided: $" + balance);
    }

        public BigDecimal addMoneyToBalance (BigDecimal amountToAdd){
            balance = balance.add(amountToAdd);
            return balance;
        }

        public BigDecimal takeMoneyForPurchase(BigDecimal price) {
            balance = balance.subtract(price);
            return balance;
        }

        public void getChange (BigDecimal balance){
            while (balance.compareTo(BigDecimal.valueOf(0.25)) == 0 || balance.compareTo(BigDecimal.valueOf(0.25)) == 1) {
                quarters = quarters + 1;
                balance = balance.subtract(BigDecimal.valueOf(0.25));
            }
            while (balance.compareTo(BigDecimal.valueOf(0.10)) == 0 || balance.compareTo(BigDecimal.valueOf(0.10)) == 1) {
                dimes = dimes + 1;
                balance = balance.subtract(BigDecimal.valueOf(0.10));
            }
            while (balance.compareTo(BigDecimal.valueOf(0.05)) == 0 || balance.compareTo(BigDecimal.valueOf(0.05)) == 1) {
                nickels = nickels + 1;
                balance = balance.subtract(BigDecimal.valueOf(0.05));
            }
            System.out.println("Please accept your chang of " + getBalance() + " in " + quarters + " Quarter(s), " + dimes + " Dime(s), " + nickels + " Nickel(s)");

        }
    }
