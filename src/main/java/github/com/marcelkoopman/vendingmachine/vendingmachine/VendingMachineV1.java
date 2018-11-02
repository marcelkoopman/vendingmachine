package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;

public class VendingMachineV1 implements VendingMachine {

    private static final Logger LOGGER = LogManager.getLogger(VendingMachineV1.class.getName());
    private static final StockRegistry stockRegistry = new DefaultStockRegistry();
    private final PriceRegistry priceRegistry;

    private Collection<Product> products = new TreeSet<>();

    public VendingMachineV1(PriceRegistry priceRegistry) {
        this.priceRegistry = priceRegistry;
    }

    @Override
    public String getName() {
        return "V1";
    }

    @Override
    public void boot() {
        LOGGER.info("Vending Machine " + getName() + " is now operational.");
    }

    @Override
    public void refill(Collection<Product> products) {
        LOGGER.info("Vending Machine refilling with products");
        this.products.addAll(products);
        LOGGER.info("Now containing " + this.products.size() + " products");
    }

    @Override
    public void shutDown() {
        LOGGER.info("Vending Machine has shut down.");
    }

    @Override
    public String getFormattedPrice(Product product) {
        return "EUR " + priceRegistry.getPriceForProduct(product);
    }

    @Override
    public Map<Product, Integer> getAvailableProducts() {
        return stockRegistry.getProductsInStock();
    }
}
