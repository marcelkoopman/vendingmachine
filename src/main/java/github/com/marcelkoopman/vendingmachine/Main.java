package github.com.marcelkoopman.vendingmachine;


import github.com.marcelkoopman.vendingmachine.api.VendingMachine;
import github.com.marcelkoopman.vendingmachine.impl.VendingMachineV1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    private static final VendingMachine vendingMachine = new VendingMachineV1();

    public static void main(String[] args) {
        vendingMachine.boot();
        LOGGER.info("Available products:");
        vendingMachine.getAvailableProducts().forEach( p -> LOGGER.info(p.getName()) );
        vendingMachine.shutDown();
    }
}
