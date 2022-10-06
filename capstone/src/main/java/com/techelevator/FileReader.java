package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader extends Item{


        final String fileName = "vendingmachine.csv";
    private BigDecimal itemPrice;

    public FileReader(String slotIdentifier, String itemName, BigDecimal price, String itemType) {
        super(slotIdentifier, itemName, price, itemType);
    }

    public List<Item> processSlotIdentifier () throws FileNotFoundException {

            final File actualFile = new File(fileName);

            final Scanner fileReader = new Scanner(actualFile);

            final List<Item> items = new ArrayList<>();

            while (fileReader.hasNextLine()) {
                final String oneLine = fileReader.nextLine();
                String[] parts = oneLine.split("\\|");
                this.setSlotIdentifier(parts[0]);
                this.setItemName(parts[1]);
                this.setPrice(itemPrice = new BigDecimal(parts[2]));
                this.setItemType(parts[3]);
            }
        }




}
