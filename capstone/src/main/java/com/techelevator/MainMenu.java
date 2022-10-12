package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;

public class MainMenu {
    //declarations
    final String DISPLAY_ITEMS_BUTTON = "1";
    final String PURCHASE_MENU_BUTTON = "2";
    final String EXIT_APP_BUTTON = "3";
    final String MAIN_MENU_FULL_TEXT = "Main MAIN_MENU_FULL_TEXT\n (1) Display vending machine items \n (2) Purchase \n (3) Exit";

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

    //main menu method
    public void displayMenu(List<Item> items) throws FileNotFoundException {
        boolean isRunning=true;
        while (isRunning) {
            System.out.println(MAIN_MENU_FULL_TEXT);
            UserInterface ui = new UserInterface();
            String input = ui.getCommands();
            if (input.equals(DISPLAY_ITEMS_BUTTON)) {
                showItemsDisplay(items);
            } else if (input.equals(PURCHASE_MENU_BUTTON)) {
                //display purchase MAIN_MENU_FULL_TEXT
                PurchaseMenu showPurchaseMenu = new PurchaseMenu();
                showPurchaseMenu.displayPurchaseMenu(items);
            } else if (input.equals(EXIT_APP_BUTTON)) {
                isRunning=false;
                exitApplication();
            } else {
                System.out.println("Invalid entry - Please enter 1 2 or 3");
            }
        }
    }

}
