package com.techelevator;

import java.util.Scanner;

public class UserInterface {
    final private Scanner userInput = new Scanner(System.in);

    public String getCommands() {
        String command = userInput.nextLine();
        return command;
    }
}
