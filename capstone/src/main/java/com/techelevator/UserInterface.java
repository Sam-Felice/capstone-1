package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //DECLARATIONS
    final private Scanner userInput = new Scanner(System.in);
    //MENU CONSTANTS
    final String MAIN_MENU_FULL_TEXT = "Main Menu\n (1) Display vending machine items \n (2) Purchase \n (3) Exit";
    final String PURCHASE_MENU_FULL_TEXT = "(1) Feed Money \n(2) Select Product \n(3) Finish Transaction";
    final String CURRENT_MONEY_PROVIDED = "Current money provided: $";
    final String HOW_MUCH_MONEY_TO_FEED_MESSAGE = "How much money would you like to add (dollars only, no coins)?";
    final String INVALID_INPUT_FEED_MONEY_MESSAGE = "Invalid input. Please feed money.";
    final String INVALID_MENU_INPUT = "Invalid entry - Please enter 1 2 or 3";
    //ITEM MESSAGES DECLARATIONS
    final String CHIP_MESSAGE = " Crunch Crunch, Yum!";
    final String CANDY_MESSAGE = " Munch Munch, Yum!";
    final String DRINK_MESSAGE = " Glug Glug, Yum!";
    final String GUM_MESSAGE = " Chew Chew, Yum!";

    //METHOD TO ALLOW USER TO INPUT
    public String getCommands() {
        String command = userInput.nextLine();
        return command;
    }

    //METHOD TO GET MAIN MENU TEXT
    public void getMAIN_MENU_FULL_TEXT() {System.out.println(MAIN_MENU_FULL_TEXT);}

    //METHOD TO GET PURCHASE MENU TEXT
    public void getPURCHASE_MENU_TEXT() {System.out.println(PURCHASE_MENU_FULL_TEXT);}

    //METHOD TO GET CURRENT MONEY PROVIDED
    public String getCURRENT_MONEY_PROVIDED() {return CURRENT_MONEY_PROVIDED;}

    //METHOD TO ASK HOW MUCH MONEY TO FEED
    public void getHOW_MUCH_MONEY_TO_FEED_MESSAGE() {System.out.println(HOW_MUCH_MONEY_TO_FEED_MESSAGE);}\
    //METHOD TO GET PLEASE FEED MONEY INPUT
    public void getINVALID_INPUT_FEED_MONEY_MESSAGE() {System.out.println(INVALID_INPUT_FEED_MONEY_MESSAGE);}
    //METHOD TO GET INVALID MESSAGE FOR A MENU INPUT
    public void getINVALID_MENU_INPUT() {System.out.println("Invalid entry - Please enter 1 2 or 3");}

    //METHOD TO DISPLAY ITEMS TO THE USER
    public void showItemsDisplay(List<Item> items) throws FileNotFoundException {
        String itemDescription="";
        for( Item singleItem : items){
            itemDescription= singleItem.getSlotIdentifier()+" "+ singleItem.getItemName()+ " $"+singleItem.getPrice()+" "+ singleItem.getStock() + " in stock";
            System.out.println(itemDescription);
        }
    }
    public String getMessage (List<Item> items, String slotIdentifier){
        Item itemClass = new Item();
        String itemType= itemClass.getProductMap(items).get(slotIdentifier).getItemType();
        if (itemType.equals("Chip")){
            return CHIP_MESSAGE;
        }
        else if (itemType.equals("Candy")){
            return CANDY_MESSAGE;
        }
        else if (itemType.equals("Drink")){
            return DRINK_MESSAGE;
        }
        else if (itemType.equals("Gum")){
            return GUM_MESSAGE;
        }
        else {
            String invalidMessage = "Invalid";
            return invalidMessage;
        }
    }
}

