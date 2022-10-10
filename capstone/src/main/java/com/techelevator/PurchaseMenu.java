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
    BigDecimal amountToAdd;
    Item selectingProduct = new Item();
    BuyerBalance balance = new BuyerBalance();
    Logging logInstance = new Logging();

    //Constructor
    public PurchaseMenu(String menu, String feedMoneyButton, String selectProductButton, String finishTransactionButton) {
        this.purchaseMenu = purchaseMenu;
        this.feedMoneyButton = feedMoneyButton;
        this.selectProductButton = selectProductButton;
        this.finishTransactionButton = finishTransactionButton;
    }

    public PurchaseMenu() {
    }

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

    public BigDecimal getAmountToAdd() {
        return amountToAdd;
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
                try {
                    amountToAdd = new BigDecimal(amountToAddAsString);
                    if (amountToAdd.compareTo(BigDecimal.valueOf(0)) == -1) {
                        System.out.println("Please feed money");
                        return;
                    } else {
                        balance.addMoneyToBalance(amountToAdd);
                        logInstance.Logger("FEED MONEY:", amountToAdd, balance.getBalance());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please feed money.");
                } catch (NullPointerException e) {
                    System.out.println("Please feed money");
                }
            } else if (input.equals(selectProductButton)) {
                MainMenu showProducts = new MainMenu();
                showProducts.showItemsDisplay(items);
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

    public void selectProduct(List<Item> items) {
        UserInterface ui = new UserInterface();
        System.out.println("Please enter slot identifier");
        String userChoice = ui.getCommands();
        userChoice = userChoice.toUpperCase();

        if (!selectingProduct.getProductMap(items).containsKey(userChoice)) {
            System.out.println("Invalid");
            return;

        } else {
            Integer specificStockForSelectedItem = selectingProduct.getStockMap(items).get(userChoice);
            String specificItemName = selectingProduct.getProductMap(items).get(userChoice).getItemName();
            BigDecimal specificPrice = selectingProduct.getProductMap(items).get(userChoice).getPrice();
            Integer stockMinusOne = specificStockForSelectedItem - 1;
            if (specificPrice.compareTo(balance.getBalance()) == 1) {
                System.out.println("Where is my money, huh?");
                return;
            }
            if (specificStockForSelectedItem == 0) {
                System.out.println("Sold out");
                return;
            } else if (selectingProduct.getStockMap(items).get(userChoice) == 1) {
                balance.takeMoneyForPurchase(specificPrice);
                selectingProduct.getStockMap(items).put(userChoice, 0);
                purchaseMessage = specificItemName + " $" + specificPrice + " $" + balance.getBalance() + " " + "Sold out";
                System.out.println(purchaseMessage);
            } else if (selectingProduct.getStockMap(items).get(userChoice)<=5) {
                balance.takeMoneyForPurchase(specificPrice);
                selectingProduct.getStockMap(items).put(userChoice, specificStockForSelectedItem - 1);
                purchaseMessage = specificItemName + " $" + specificPrice + " $" + balance.getBalance() + " " + selectingProduct.getStockMap(items).get(userChoice) + " in stock after purchase";
                System.out.println(purchaseMessage);
            }
        }
        logInstance.Logger(selectingProduct.getProductMap(items).get(userChoice).getItemName()+" " + selectingProduct.getProductMap(items).get(userChoice).getSlotIdentifier(), selectingProduct.getProductMap(items).get(userChoice).getPrice(), balance.getBalance());
    }
}
