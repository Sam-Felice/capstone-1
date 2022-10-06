package com.techelevator;

public class PurchaseMenu {

    private String menu = "Main menu\n (1) Display vending machine items \n (2) Purchase \n (3) Exit";
    private String feedMoneyButton = "1";
    private String selectProductButton = "2";
    private String finishTransactionButton = "3";

//Constructor
    public PurchaseMenu(String menu, String feedMoneyButton, String selectProductButton, String finishTransactionButton) {
        this.menu = menu;
        this.feedMoneyButton = feedMoneyButton;
        this.selectProductButton = selectProductButton;
        this.finishTransactionButton = finishTransactionButton;
    }
//Getters
    public String getMenu() {
        return menu;
    }

    public String getFeedMoneyButton() {
        return feedMoneyButton;
    }

    public String getSelectProductButton() {
        return selectProductButton;
    }

    public String getFinishTransactionButton() {
        return finishTransactionButton;
    }


//    Setters
    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setFeedMoneyButton(String feedMoneyButton) {
        this.feedMoneyButton = feedMoneyButton;
    }

    public void setSelectProductButton(String selectProductButton) {
        this.selectProductButton = selectProductButton;
    }

    public void setFinishTransactionButton(String finishTransactionButton) {
        this.finishTransactionButton = finishTransactionButton;
    }
}
