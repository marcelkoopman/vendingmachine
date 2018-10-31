package github.com.marcelkoopman.vendingmachine;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());


    public static void main(String[] args) {
        LOGGER.info("VendingMachine up");
        LOGGER.info("VendingMachine down");
    }
}
