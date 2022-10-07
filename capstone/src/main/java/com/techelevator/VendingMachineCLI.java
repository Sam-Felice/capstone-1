package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class VendingMachineCLI {


	public VendingMachineCLI() {
	}

	public void run() throws FileNotFoundException {
		MainMenu mainMenu = new MainMenu();
		// read inventory file here
		FileReader fileReader = new FileReader(new File("vendingmachine.csv"));
		List<Item> items = fileReader.getItems();
		mainMenu.displayMenu(items);
	}

	public static void main(String[] args) throws FileNotFoundException {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}









}
