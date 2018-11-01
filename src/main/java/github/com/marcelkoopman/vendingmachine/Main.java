package github.com.marcelkoopman.vendingmachine;


import github.com.marcelkoopman.vendingmachine.product.Product;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachine;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineV1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    private static final VendingMachine vendingMachine = new VendingMachineV1();

    private static final Map<String, String> commands = new TreeMap<>();

    static {
        commands.put("help", "Show this help text");
        commands.put("select", "Select this product");
        commands.put("price", "Show price of this product");
        commands.put("list", "Show all available products");
        commands.put("quit", "Quit application");
    }

    public static void main(String[] args) {
        vendingMachine.boot();
        LOGGER.info(getHelp());

        Scanner scanner = new Scanner(System.in);
        while (readFromConsole(scanner)) {
            //
        }
        vendingMachine.shutDown();
    }

    private static boolean readFromConsole(Scanner scanner) {
        final String line = scanner.nextLine();
        final boolean continueReading;
        if ("help".equals(line)) {
            LOGGER.info(getHelp());
            continueReading = true;
        } else if ("quit".equals(line)) {
            LOGGER.info("Quitting...");
            continueReading = false;
        } else if ("list".equals(line)) {
            final Map<Product, Integer> products = vendingMachine.getAvailableProducts();
            LOGGER.info("Available products: " + products.entrySet().stream().map(p -> p.getKey().getName()).collect(Collectors.joining(",")));
            continueReading = true;
        } else {
            LOGGER.warn("Unrecognized command: " + line);
            continueReading = true;
        }
        return continueReading;
    }

    // Retrieve and show all products in a single list.
    // Accept user input for selecting a product.
    // Show the price for a selected product.
    // Accept user input for paying for the selected product.
    // Display the purchased product.


    private static String getHelp() {
        final StringBuilder builder = new StringBuilder();
        builder.append(commands);
        return builder.toString();
    }
}
