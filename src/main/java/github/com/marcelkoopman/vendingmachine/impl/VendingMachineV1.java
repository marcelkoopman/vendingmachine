package github.com.marcelkoopman.vendingmachine.impl;

import github.com.marcelkoopman.vendingmachine.Main;
import github.com.marcelkoopman.vendingmachine.api.Product;
import github.com.marcelkoopman.vendingmachine.api.ProductRegistry;
import github.com.marcelkoopman.vendingmachine.api.VendingMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class VendingMachineV1 implements VendingMachine {

    private static final Logger LOGGER = LogManager.getLogger(VendingMachineV1.class.getName());

    private final ProductRegistry productRegistry = new CandyProductRegistry();

    @Override
    public void boot() {
        LOGGER.info("Vending Machine is up.");
    }

    @Override
    public void shutDown() {
        LOGGER.info("Vending Machine has shut down.");
    }

    @Override
    public Set<Product> getAvailableProducts() {
        return productRegistry.getProducts();
    }
}
