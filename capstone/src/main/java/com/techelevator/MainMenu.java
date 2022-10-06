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
    public void showItemsDisplay() throws FileNotFoundException {
        FileReader instance = new FileReader();


        System.out.println(instance.processFile());
//      System.out.println("Hello world");
    }

    //Exit method
    public void exitApplication() {
        System.exit(3);
    }

    //method
    public void displayMenu() throws FileNotFoundException {
        System.out.println(menu);
        UserInterface ui = new UserInterface();
        String input = ui.getCommands();
        if(input.equals("1")){
            showItemsDisplay();
        }
        else if (input.equals("2")){
            //display purchase menu
        }
        else if (input.equals("3")){
            exitApplication();
        } else{
            System.out.println("Invalid entry - Please enter 1 2 or 3");
        }
    }

}
