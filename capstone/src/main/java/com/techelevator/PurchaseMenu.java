package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class PurchaseMenu {

    final String FEED_MONEY_BUTTON = "1";
    final String SELECT_PRODUCT_BUTTON = "2";
    final String FINISH_TRANSACTION_BUTTON = "3";
    private String purchaseMessage = "";
    BigDecimal amountToAdd;
    Item selectingProduct = new Item();
    BuyerBalance balance = new BuyerBalance();
    Logging logInstance = new Logging();

    //Constructor

    public PurchaseMenu() {
    }

    //Getters

    public String getFEED_MONEY_BUTTON() {
        return FEED_MONEY_BUTTON;
    }

    public String getSELECT_PRODUCT_BUTTON() {
        return SELECT_PRODUCT_BUTTON;
    }

    public String getFINISH_TRANSACTION_BUTTON() {
        return FINISH_TRANSACTION_BUTTON;
    }

    public BigDecimal getAmountToAdd() {
        return amountToAdd;
    }

    //methods
    public void displayPurchaseMenu(List<Item> items) throws FileNotFoundException {
        boolean transactionFinished = false;

        while (transactionFinished == false) {
            UserInterface ui = new UserInterface();
            System.out.println(ui.getCURRENT_MONEY_PROVIDED()+ balance.getBalance());
            ui.getPURCHASE_MENU_TEXT();
            String input = ui.getCommands();
            if (input.equals(FEED_MONEY_BUTTON)) {
                ui.getHOW_MUCH_MONEY_TO_FEED_MESSAGE();
                String amountToAddAsString = ui.getCommands();
                try {
                    amountToAdd = new BigDecimal(amountToAddAsString);
                    if (amountToAdd.compareTo(BigDecimal.valueOf(0)) == -1) {
                        ui.getINVALID_INPUT_FEED_MONEY_MESSAGE();
                        return;
                    } else {
                        balance.addMoneyToBalance(amountToAdd);
                        logInstance.Logger("FEED MONEY:", amountToAdd, balance.getBalance());
                    }
                } catch (NumberFormatException e) {
                    ui.getINVALID_INPUT_FEED_MONEY_MESSAGE();
                } catch (NullPointerException e) {
                    ui.getINVALID_INPUT_FEED_MONEY_MESSAGE();
                }
            } else if (input.equals(SELECT_PRODUCT_BUTTON)) {
                MainMenu showProducts = new MainMenu();
                ui.showItemsDisplay(items);
                selectProduct(items);
                //select product
            } else if (input.equals(FINISH_TRANSACTION_BUTTON)) {
                balance.getChange(balance.getBalance());
                transactionFinished = true;
                return;
            } else {
                ui.getINVALID_MENU_INPUT();
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
