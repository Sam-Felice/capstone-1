package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;

public class MainMenu {
    //declarations
    final String DISPLAY_ITEMS_BUTTON = "1";
    final String PURCHASE_MENU_BUTTON = "2";
    final String EXIT_APP_BUTTON = "3";

    //empty constructor
    public MainMenu() {}

    //Exit method
    public void exitApplication() {
        System.exit(3);
    }

    //main menu method
    public void displayMenu(List<Item> items) throws FileNotFoundException {
        boolean isRunning=true;
        while (isRunning) {
            UserInterface ui = new UserInterface();
            ui.getMAIN_MENU_FULL_TEXT();
            String input = ui.getCommands();
            if (input.equals(DISPLAY_ITEMS_BUTTON)) {
                ui.showItemsDisplay(items);
            } else if (input.equals(PURCHASE_MENU_BUTTON)) {
                //display purchase MAIN_MENU_FULL_TEXT
                PurchaseMenu showPurchaseMenu = new PurchaseMenu();
                showPurchaseMenu.displayPurchaseMenu(items);
            } else if (input.equals(EXIT_APP_BUTTON)) {
                isRunning=false;
                exitApplication();
            } else {
                ui.getINVALID_MENU_INPUT();
            }
        }
    }

}
