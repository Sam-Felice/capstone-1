package com.techelevator;

import java.math.BigDecimal;

public class BuyerBalance {
    

    private BigDecimal balance;

    public BuyerBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
