package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BuyerBalance {
    //declaration
    private BigDecimal balance = new BigDecimal(0.00);
    private int quarters = 0;
    private int dimes = 0;
    private int nickels = 0;
    private BigDecimal amountToAdd;
    Logging log = new Logging();

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

    public BigDecimal getAmountToAdd(){return amountToAdd;}

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
            log.Logger("GIVE CHANGE: ", getBalance(), BigDecimal.valueOf(0.00));
            System.out.println("Please accept your change of " + getBalance() + " in " + quarters + " Quarter(s), " + dimes + " Dime(s), " + nickels + " Nickel(s)");

        }
    }
