package github.com.marcelkoopman.vendingmachine;


import github.com.marcelkoopman.vendingmachine.api.VendingMachine;
import github.com.marcelkoopman.vendingmachine.impl.VendingMachineV1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    private static final VendingMachine vendingMachine = new VendingMachineV1();

    public static void main(String[] args) {
        vendingMachine.boot();
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
        } else {
            LOGGER.warn("Unrecognized command: " + line);
            continueReading = true;
        }
        return continueReading;
    }

    private static String getHelp() {
        final StringBuilder builder = new StringBuilder();
        builder.append("help = show this help");
        builder.append(", ");
        builder.append("quit = quit application");
        return builder.toString();
    }
}
