package github.com.marcelkoopman.vendingmachine.vendingmachine.terminal;

import github.com.marcelkoopman.vendingmachine.product.model.Product;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachine;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineException;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineFiller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
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
        final String line = scanner.nextLine().trim();
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
        try {
            final Product product = getProductFromInput(line);
            LOGGER.info("Product info: " + product);
        } catch (VendingMachineException e) {
            LOGGER.error(e);
        }
    }

    private void doListProducts() {
        final Product[] products = vendingMachine.getAvailableProducts();
        if (products.length == 0) {
            LOGGER.info("Out of stock, use refill to restock");
        } else {
            LOGGER.info("Available products");
            LOGGER.info("------------------");
            for (int i = 0; i < products.length; ++i) {
                LOGGER.info("" + i + " = " + products[i]);
            }
        }
    }

    private Product getProductFromInput(String line) throws VendingMachineException {
        final Integer productNo = parseProductNumber(line);
        final Product[] products = vendingMachine.getAvailableProducts();
        if (productNo >= 0 && productNo < products.length) {
            final Product product = products[productNo];
            return product;
        } else {
            throw new VendingMachineException("This product number " + productNo + " does not exist");
        }
    }

    private void doPriceProduct(String line) {
        try {
            final Product product = getProductFromInput(line);
            LOGGER.info(product + " price: " + vendingMachine.getFormattedPrice(product));
        } catch (VendingMachineException e) {
            LOGGER.error(e);
        }
    }

    private void doBuyProduct(String line) {
        try {
            final Product product = getProductFromInput(line);
            vendingMachine.buyProduct(product);
            doListProducts();
        } catch (VendingMachineException e) {
            LOGGER.error(e);
        }
    }

    private Integer parseProductNumber(String line) throws VendingMachineException {
        final String[] split = line.split(" ");
        if (split == null || split.length <= 1) {
            throw new VendingMachineException("Unknown index for product!");
        }
        return Integer.valueOf(split[1].trim());
    }

    private String getHelp() {
        final StringBuilder builder = new StringBuilder();
        builder.append(commands);
        return builder.toString();
    }
}
