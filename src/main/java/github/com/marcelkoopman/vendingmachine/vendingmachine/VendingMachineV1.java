package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.CandyProductRegistry;
import github.com.marcelkoopman.vendingmachine.product.Product;
import github.com.marcelkoopman.vendingmachine.product.ProductRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class VendingMachineV1 implements VendingMachine {

    private static final Logger LOGGER = LogManager.getLogger(VendingMachineV1.class.getName());

    private final ProductRegistry productRegistry = new CandyProductRegistry();
    private static final StockRegistry stockRegistry = new DefaultStockRegistry();

    @Override
    public void boot() {
        refill();
        LOGGER.info("Available products:");
        getAvailableProducts().entrySet().stream().forEach(e ->
                LOGGER.info("{} - {}", e.getKey(), e.getValue()));

        LOGGER.info("Vending Machine is now operational.");
    }

    @Override
    public void refill() {
        LOGGER.info("Vending Machine refilling with products");
        for (Product product : productRegistry.getProducts()) {
            stockRegistry.stockProduct(product);
        }
    }

    @Override
    public void shutDown() {
        LOGGER.info("Vending Machine has shut down.");
    }

    @Override
    public Map<Product, Integer> getAvailableProducts() {
        return stockRegistry.getProductsInStock();
    }
}
