package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class PurchaseMenu {

    private String purchaseMenu = "\n(1) Feed Money \n(2) Select Product \n(3) Finish Transaction";
    private String feedMoneyButton = "1";
    private String selectProductButton = "2";
    private String finishTransactionButton = "3";
    private String purchaseMessage = "";
    Item selectingProduct = new Item();
    BuyerBalance balance = new BuyerBalance();
//Constructor
    public PurchaseMenu(String menu, String feedMoneyButton, String selectProductButton, String finishTransactionButton) {
        this.purchaseMenu = purchaseMenu;
        this.feedMoneyButton = feedMoneyButton;
        this.selectProductButton = selectProductButton;
        this.finishTransactionButton = finishTransactionButton;
    }
    public PurchaseMenu(){}
//Getters
    public String getPurchaseMenu() {
        return purchaseMenu;
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

    //methods
    public void displayPurchaseMenu(List<Item> items) throws FileNotFoundException {
        boolean transactionFinished = false;

        while (transactionFinished == false) {
            System.out.printf("Current money provided: $%s", balance.getBalance());
            System.out.println(purchaseMenu);
            UserInterface ui = new UserInterface();
            String input = ui.getCommands();
            if (input.equals(feedMoneyButton)) {
                System.out.println("How much money would you like to add (dollars only, no coins)?");
                String amountToAddAsString = ui.getCommands();
                BigDecimal amountToAdd = new BigDecimal(amountToAddAsString);
                balance.addMoneyToBalance(amountToAdd);
            } else if (input.equals(selectProductButton)) {
                MainMenu showProducts = new MainMenu();
                showProducts.showItemsDisplay();
                selectProduct(items);
                //select product
            } else if (input.equals(finishTransactionButton)) {
                balance.getChange(balance.getBalance());
                transactionFinished = true;
                return;
            } else {
                System.out.println("Invalid entry - Please enter 1 2 or 3");
            }
        }
    }
        public void selectProduct(List<Item> items){
            UserInterface ui = new UserInterface();
            System.out.println("Please enter slot identifier");
            String userChoice = ui.getCommands();
            Integer specificStockForSelectedItem = selectingProduct.getStockMap(items).get(userChoice);
            Integer stockMinusOne = specificStockForSelectedItem -1;
            String specificItemName = selectingProduct.getProductMap(items).get(userChoice).getItemName();
            BigDecimal specificPrice = selectingProduct.getProductMap(items).get(userChoice).getPrice();
            if(specificStockForSelectedItem==0){
                System.out.println("Sold out");
                return;
            } else if (selectingProduct.getStockMap(items).get(userChoice)==1){
                balance.takeMoneyForPurchase(specificPrice);
                selectingProduct.getStockMap(items).put(userChoice, 0);
                purchaseMessage = specificItemName+ " $" + specificPrice + " $" +balance.getBalance()+ " " + "Sold out";
                System.out.println(purchaseMessage);
            } else if(selectingProduct.getStockMap(items).get(userChoice)==2){
                balance.takeMoneyForPurchase(specificPrice);
                selectingProduct.getStockMap(items).put(userChoice, 1);
                purchaseMessage = specificItemName+ " $" + specificPrice + " $" + balance.getBalance()+" " + selectingProduct.getStockMap(items).get(userChoice) + " in stock after purchase";
                System.out.println(purchaseMessage);
            }else if(selectingProduct.getStockMap(items).get(userChoice)==3){
                balance.takeMoneyForPurchase(specificPrice);
                selectingProduct.getStockMap(items).put(userChoice, 2);
                purchaseMessage = specificItemName+ " $" + specificPrice + " $" + balance.getBalance()+" " + selectingProduct.getStockMap(items).get(userChoice) + " in stock after purchase";
                System.out.println(purchaseMessage);
            }else if(selectingProduct.getStockMap(items).get(userChoice)==4){
                balance.takeMoneyForPurchase(specificPrice);
                selectingProduct.getStockMap(items).put(userChoice, 3);
                purchaseMessage = specificItemName+ " $" + specificPrice + " $" + balance.getBalance()+" " + selectingProduct.getStockMap(items).get(userChoice) + " in stock after purchase";
                System.out.println(purchaseMessage);
            }else if(selectingProduct.getStockMap(items).get(userChoice).equals(5)){
                balance.takeMoneyForPurchase(specificPrice);
                selectingProduct.getStockMap(items).put(userChoice, 4);
                purchaseMessage = specificItemName+ " $" + specificPrice + " $" + balance.getBalance()+" " + selectingProduct.getStockMap(items).get(userChoice) + " in stock after purchase" + selectingProduct.getMessage(items, userChoice);
                System.out.println(purchaseMessage);
            }
        }

}
