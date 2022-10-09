package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Logging {

    final File log = new File("log.txt");
    /*BuyerBalance balance = new BuyerBalance();
    PurchaseMenu pm = new PurchaseMenu();*/


    public void Logger(String transaction , BigDecimal transactionAmount, BigDecimal balanceRemaining){
        try (final FileOutputStream fos = new FileOutputStream(log, true);
             final PrintWriter writer = new PrintWriter(fos)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            writer.println(dtf.format(now) + " " + transaction + " $" + transactionAmount + " $" + balanceRemaining);
        } catch (IOException e) {
            System.out.println("could not find file");
        }

    }
}