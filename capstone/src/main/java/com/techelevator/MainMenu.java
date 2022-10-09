package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class MainMenu {
    //declarations
    private String displayItems = "1";
    private String enterPurchaseMenu = "2";
    private String exitApp = "3";
    private String menu = "Main menu\n (1) Display vending machine items \n (2) Purchase \n (3) Exit";
    //constructor
    public MainMenu(String displayItems, String enterPurchaseMenu, String exitApp) {
        this.displayItems = displayItems;
        this.enterPurchaseMenu = enterPurchaseMenu;
        this.exitApp = exitApp;
    }

    //empty constructor
    public MainMenu() {

    }

    //Display items method
    public void showItemsDisplay(List<Item> items) throws FileNotFoundException {
            String itemDescription="";
            for( Item singleItem : items){
                itemDescription= singleItem.getSlotIdentifier()+" "+ singleItem.getItemName()+ " $"+singleItem.getPrice()+" "+ singleItem.getStock() + " in stock";
                System.out.println(itemDescription);
            }
        }

    //Exit method
    public void exitApplication() {
        System.exit(3);
    }

    //method
    public void displayMenu(List<Item> items) throws FileNotFoundException {
        boolean isRunning=true;
        while (isRunning) {
            System.out.println(menu);
            UserInterface ui = new UserInterface();
            String input = ui.getCommands();
            if (input.equals(displayItems)) {
                showItemsDisplay(items);
            } else if (input.equals(enterPurchaseMenu)) {
                //display purchase menu
                PurchaseMenu showPurchaseMenu = new PurchaseMenu();
                showPurchaseMenu.displayPurchaseMenu(items);
            } else if (input.equals(exitApp)) {
                isRunning=false;
                exitApplication();
            } else {
                System.out.println("Invalid entry - Please enter 1 2 or 3");
            }
        }
    }

}
