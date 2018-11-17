package github.com.marcelkoopman.vendingmachine.vendingmachine.terminal;

import github.com.marcelkoopman.vendingmachine.product.model.Product;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachine;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineException;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineFiller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachineTerminal {

    private static final Logger LOGGER = LogManager.getLogger(VendingMachineTerminal.class.getName());

    private static final Map<String, String> commands = new TreeMap<>();

    static {
        commands.put("help", "Show this help text");
        commands.put("select", "Select this product");
        commands.put("price", "Show price of this product");
        commands.put("buy", "Buy product");
        commands.put("list", "Show all available products");
        commands.put("quit", "Quit application");
    }

    private final VendingMachine vendingMachine;
    private final VendingMachineFiller vendingMachineFiller;

    public VendingMachineTerminal(VendingMachine vendingMachine, VendingMachineFiller vendingMachineFiller) {
        this.vendingMachine = vendingMachine;
        this.vendingMachineFiller = vendingMachineFiller;
    }

    public void boot() {
        doRefill();
        Scanner scanner = new Scanner(System.in);
        while (readFromConsole(scanner)) {
            //
        }
    }

    private boolean readFromConsole(Scanner scanner) {
        var line = scanner.nextLine().trim();
        final boolean continueReading;
        if ("help".equals(line)) {
            doHelp();
            continueReading = true;
        } else if ("quit".equals(line)) {
            doQuit();
            continueReading = false;
        } else if ("refill".equals(line)) {
            doRefill();
            continueReading = true;
        } else if ("list".equals(line)) {
            doListProducts();
            continueReading = true;
        } else if (line.startsWith("price")) {
            doPriceProduct(line);
            continueReading = true;
        } else if (line.startsWith("select")) {
            doSelectProduct(line);
            continueReading = true;
        } else if (line.startsWith("buy")) {
            doBuyProduct(line);
            continueReading = true;
        } else {
            LOGGER.warn("Unrecognized command: " + line);
            continueReading = true;
        }
        return continueReading;
    }


    private void doHelp() {
        LOGGER.info(getHelp());
    }

    private void doQuit() {
        LOGGER.info("Quitting...");
    }

    private void doRefill() {
        vendingMachineFiller.fillVendingMachine(vendingMachine);
        doListProducts();
        doHelp();
    }

    private void doSelectProduct(String line) {
        getProductFromInput(line).ifPresent(p -> LOGGER.info("Product info: " + p));
    }

    private void doListProducts() {
        vendingMachine.getAllProducts().forEach(p -> LOGGER.info("Product: " + p));
    }

    private Optional<Product> getProductFromInput(String line) {
        var product = vendingMachine.getAllProducts().filter(p -> findProductInLine(line, p)).findFirst();
        if (product.isEmpty()) {
            LOGGER.warn("Cant determine any product matching " + line);
        }
        return product;
    }

    private boolean findProductInLine(String line, Product p) {
        var toffset = line.indexOf(' ') + 1;
        var seek = line.substring(toffset).trim().toUpperCase();
        return p.getName().toUpperCase().contains(seek);
    }

    private void doPriceProduct(String line) {
        getProductFromInput(line).ifPresent(p -> LOGGER.info(p + " price: " + vendingMachine.getFormattedPrice(p)));
    }

    private void doBuyProduct(String line) {
        getProductFromInput(line).ifPresent(p -> {
            try {
                vendingMachine.buyProduct(p);
            } catch (VendingMachineException e) {
                LOGGER.error(e);
            }
        });
        doListProducts();
    }

    private String getHelp() {
        var builder = new StringBuilder();
        builder.append(commands);
        return builder.toString();
    }
}
