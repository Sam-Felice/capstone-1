package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

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
    public void displayPurchaseMenu() throws FileNotFoundException {
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
                selectProduct();
                //select product
            } else if (input.equals(finishTransactionButton)) {
                transactionFinished = true;
                return;
            } else {
                System.out.println("Invalid entry - Please enter 1 2 or 3");
            }
        }
    }
        public void selectProduct(){
            UserInterface ui = new UserInterface();
            System.out.println("Please enter slot identifier");
            String userChoice = ui.getCommands();
            int specificStockForSelectedItem = selectingProduct.getProductMap().get(userChoice).getStock();
            if(specificStockForSelectedItem==0){
                System.out.println("Sold out");
                return;
            } else if (specificStockForSelectedItem==1){
                balance.takeMoneyForPurchase(selectingProduct.getProductMap().get(userChoice).getPrice());
                selectingProduct.subtractsOneFromStock(userChoice);
                purchaseMessage = selectingProduct.getProductMap().get(userChoice).getItemName()+ " $" + selectingProduct.getProductMap().get(userChoice).getPrice() + " $" +balance.getBalance()+ " " + "Sold out";
                System.out.println(purchaseMessage);
            } else if(specificStockForSelectedItem>1){
                balance.takeMoneyForPurchase(selectingProduct.getProductMap().get(userChoice).getPrice());
                selectingProduct.subtractsOneFromStock(userChoice);
                purchaseMessage = selectingProduct.getProductMap().get(userChoice).getItemName()+ " $" + selectingProduct.getProductMap().get(userChoice).getPrice() + " $" + balance.getBalance()+" " + selectingProduct.getProductMap().get(userChoice).getStock()2
            ;
                System.out.println(purchaseMessage);
            }
        }

}
