package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class MainMenu {
    //declarations
    private char displayItems = '1';
    private char enterPurchaseMenu = '2';
    private char exitApp = '3';
    private String menu = "Main menu\n (1) Display vending machine items \n (2) Purchase \n (3) Exit";
    //constructor
    public MainMenu(char displayItems, char enterPurchaseMenu, char exitApp) {
        this.displayItems = displayItems;
        this.enterPurchaseMenu = enterPurchaseMenu;
        this.exitApp = exitApp;
    }
    //methods
    public void showItemsDisplay() throws FileNotFoundException {
        FileReader instance = new FileReader();
        System.out.println(instance.processFile());
    }
}
