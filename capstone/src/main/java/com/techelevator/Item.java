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

    private int stock =5;
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

    public int getStock() {
        return stock;
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
    public Item(String slotIdentifier, String itemName, BigDecimal price, String itemType, int stock) {
        this.slotIdentifier = slotIdentifier;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
        this.stock = stock;
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
        int specificStockForSelectedItem = getProductMap().get(userChoice).getStock();
        if(specificStockForSelectedItem==0){
            System.out.println("Sold out");
            selectProduct();
        } else if (specificStockForSelectedItem==1){
            specificStockForSelectedItem= specificStockForSelectedItem-1;
            purchaseMessage = getProductMap().get(userChoice).getItemName()+ " $" + getProductMap().get(userChoice).getPrice() + " " + balance.getBalance() + " " + "Sold out";
            System.out.println(purchaseMessage);
        } else if(specificStockForSelectedItem>1){
            specificStockForSelectedItem= specificStockForSelectedItem-1;
            purchaseMessage = getProductMap().get(userChoice).getItemName()+ " $" + getProductMap().get(userChoice).getPrice() + " " + balance.getBalance() + " " + specificStockForSelectedItem;
            System.out.println(purchaseMessage);
        }
    }
}
