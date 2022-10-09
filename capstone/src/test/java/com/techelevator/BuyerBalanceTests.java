package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BuyerBalanceTests {

    @Test
    public void add_five_to_balance(){
//        Arrange
        BuyerBalance buyBal = new BuyerBalance();
        BigDecimal amountToAdd = new BigDecimal(5);
//        Act
        BigDecimal result = buyBal.addMoneyToBalance(amountToAdd);
        BigDecimal expected = new BigDecimal(5);
//        Assert
        Assert.assertEquals("Should return balance of 5",expected , result);
    }
    @Test
    public void take_five_from_balance(){
//        Arrange
        BuyerBalance setBalance = new BuyerBalance(BigDecimal.valueOf(10));
        BigDecimal amountToTake = new BigDecimal(5);
//        Act
        BigDecimal result = setBalance.takeMoneyForPurchase(amountToTake);
        BigDecimal expected = new BigDecimal(5);
//        Assert
        Assert.assertEquals("Should return balance of 5",expected , result);
    }


}
