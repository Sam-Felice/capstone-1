package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader extends Item{


    final String fileName = "vendingmachine.csv";

    public FileReader(String line) {
        super(line);
    }
    public FileReader(){

    }

    public List<Item> processFile() throws FileNotFoundException {

            final File actualFile = new File(fileName);

            final Scanner fileReader = new Scanner(actualFile);

            final List<Item> items = new ArrayList<>();

            while (fileReader.hasNextLine()) {
                final String oneLine = fileReader.nextLine();
                Item i = new Item(oneLine);
                items.add(i);
            }
            return items;
        }




}
