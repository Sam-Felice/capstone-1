package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String slotIdentifier;
    private String itemName;
    private BigDecimal price;
    private String itemType;

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


    public Item(String line){
            String[] lineParts = line.split("\\|");
            this.slotIdentifier = lineParts[0];
            this.itemName = lineParts[1];
            this.price=  price = new BigDecimal(lineParts[2]);
            this.itemType = lineParts[4];
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }
}
