package github.com.marcelkoopman.vendingmachine;


import github.com.marcelkoopman.vendingmachine.vendingmachine.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    private static final VendingMachine vendingMachine = new VendingMachineV1(new DefaultPriceRegistry());
    private static final VendingMachineFiller filler = new VendingMachineFiller();

    public static void main(String[] args) {
        vendingMachine.boot();
        new VendingMachineTerminal(vendingMachine, filler).boot();
        vendingMachine.shutDown();
    }


    // Retrieve and show all products in a single list.
    // Accept user input for selecting a product.
    // Show the price for a selected product.
    // Accept user input for paying for the selected product.
    // Display the purchased product.

}
