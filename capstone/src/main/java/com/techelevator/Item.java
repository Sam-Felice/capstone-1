package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {

    private String slotIdentifier;
    private String itemName;
    private BigDecimal price;
    private String itemType;
    private String chipMessage = " Crunch Crunch, Yum!";
    private String candyMessage = " Munch Munch, Yum!";
    private String drinkMessage = " Glug Glug, Yum!";
    private String gumMessage = " Chew Chew, Yum!";

    private Integer stock =5;
    BuyerBalance balance = new BuyerBalance();

    private Map<String, Item> productMap = new HashMap<>();
    private Map <String, Integer> stockMap = new HashMap<>();

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
    public Item(String slotIdentifier, String itemName, BigDecimal price, String itemType, Integer stock) {
        this.slotIdentifier = slotIdentifier;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
        this.stock = stock;
    }

    // method
    public Map<String, Item> getProductMap (List<Item> items){
        for (Item singleItem : items){
            productMap.put(singleItem.getSlotIdentifier(), singleItem);
        }
        return productMap;
    }
    public Map<String, Integer> getStockMap (List<Item> items){
        for(Item singleItem : items){
            stockMap.put(singleItem.getSlotIdentifier(), stock);
        }
        return stockMap;
    }
    public int subtractsOneFromStock(List<Item>items,String slotIdentifier){
       int specificStock = getProductMap(items).get(slotIdentifier).getStock();
       specificStock = specificStock -1;
        return specificStock;
    }

    public String getMessage (List<Item> items, String slotIdentifier){
        if (getProductMap(items).get(slotIdentifier).getItemType().equals("Chip")){
            return chipMessage;
        }
        else if (getProductMap(items).get(slotIdentifier).getItemType().equals("Candy")){
            return candyMessage;
        }
        else if (getProductMap(items).get(slotIdentifier).getItemType().equals("Drink")){
            return drinkMessage;
        }
        else if (getProductMap(items).get(slotIdentifier).getItemType().equals("Gum")){
            return gumMessage;
        }
        else { String invalidMessage = "Invalid";
            return invalidMessage;
        }
    }
}
