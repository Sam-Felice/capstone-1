package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class FileReaderTests {
    @Test
    public void getItemsList(){
        FileReader fileReader = new FileReader(new File("vendingmachine.csv"));
        List<Item> result = fileReader.getItems();
        Assert.assertEquals("Should return list of items", fileReader.getItems(), result);
    }
}
