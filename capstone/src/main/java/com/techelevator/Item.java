package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Item {

    private String slotIdentifier;
    private String itemName;
    private BigDecimal price;
    private String itemType;
    private String purchaseMessage = "";
    BuyerBalance balance = new BuyerBalance();

    private Map<String, Item> productMap = new HashMap<>();

    public Item() {
    }



//    Getters



    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }


//    Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }


//    Constructor

/*    public Item(String line){
            String[] lineParts = line.split("\\|");
            this.slotIdentifier = lineParts[0];
            this.itemName = lineParts[1];
            this.price=  price = new BigDecimal(lineParts[2]);
            this.itemType = lineParts[3];
    }*/
    public Item(String slotIdentifier, String itemName, BigDecimal price, String itemType) {
        this.slotIdentifier = slotIdentifier;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
    }

    // method
    /*public String displayItem(){
        String itemInfo = slotIdentifier + " " + itemName + " " + price + " " + itemType;
        return displayItem();
    }*/
    public Map<String, Item> getProductMap (){
        FileReader retrievingItems = new FileReader(new File("vendingmachine.csv"));
        for (Item singleItem : retrievingItems.getItems()){
            productMap.put(singleItem.getSlotIdentifier(), singleItem);
        }
        return productMap;
    }


    public void selectProduct(){
        UserInterface ui = new UserInterface();
        System.out.println("Please enter slot identifier");
        String userChoice = ui.getCommands();
        purchaseMessage = getProductMap().get(userChoice).getItemName()+ " $" + getProductMap().get(userChoice).getPrice() + " " + balance.getBalance();
        System.out.println(purchaseMessage);
    }

}
