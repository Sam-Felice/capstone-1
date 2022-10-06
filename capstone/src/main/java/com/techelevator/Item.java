package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String slotIdentifier;
    private String itemName;
    private BigDecimal price;
    private String itemType;


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


//    Constructor


    public Item(String slotIdentifier, String itemName, BigDecimal price, String itemType) {
        this.slotIdentifier = slotIdentifier;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }
}
