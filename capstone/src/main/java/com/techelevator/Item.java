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
    public Item(String slotIdentifier, String itemName, BigDecimal price, String itemType, int stock) {
        this.slotIdentifier = slotIdentifier;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
        this.stock = stock;
    }

    // method
    public Map<String, Item> getProductMap (){
        FileReader retrievingItems = new FileReader(new File("vendingmachine.csv"));
        for (Item singleItem : retrievingItems.getItems()){
            productMap.put(singleItem.getSlotIdentifier(), singleItem);
        }
        return productMap;
    }
    public int subtractsOneFromStock(String slotIdentifier){
        stock=getProductMap().get(slotIdentifier).getStock()-1;
        return stock;
    }
}
