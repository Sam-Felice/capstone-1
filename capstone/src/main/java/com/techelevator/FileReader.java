package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader extends Item{

    List<Item> items = new ArrayList<>();
    File actualFile;



 /*   public FileReader(String line) {
        super(line);
    }*/
    public FileReader(File actualFile){
        this.actualFile=actualFile;
    }

    public File getActualFile() {
        return actualFile;
    }

    public void setActualFile(File actualFile) {
        this.actualFile = actualFile;
    }

    public List<Item> getItems() {

        /*final File actualFile = new File("vendingmachine.csv");*/

        try (final Scanner fileReader = new Scanner(actualFile)) {

            while (fileReader.hasNextLine()) {
                final String oneLine = fileReader.nextLine();
                /*Item i = new Item(oneLine);*/
                Item i = new Item();
                String[] lineParts = oneLine.split("\\|");
                i.setSlotIdentifier(lineParts[0]);
                i.setItemName(lineParts[1]);
                i.setPrice(new BigDecimal(lineParts[2]));
                i.setItemType(lineParts[3]);
                items.add(i);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return items;
    }
    public void displayItemsList(){
        String itemDescription="";
        for( Item singleItem : getItems()){
            itemDescription= singleItem.getSlotIdentifier()+" "+ singleItem.getItemName()+ " $"+singleItem.getPrice()+" "+ singleItem.getItemType();
            System.out.println(itemDescription);
        }
    }




}
