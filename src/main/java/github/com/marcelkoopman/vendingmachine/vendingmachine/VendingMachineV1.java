package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class VendingMachineV1 implements VendingMachine {

    private static final Logger LOGGER = LogManager.getLogger(VendingMachineV1.class.getName());
    private final PriceRegistry priceRegistry;

    private Set<Product> productList = new TreeSet();

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
        LOGGER.info("Vending Machine refilling with " + products.size() + " products");
        productList.addAll(products);
        LOGGER.info("Now containing " + this.productList.size() + " products");
    }

    @Override
    public void shutDown() {
        LOGGER.info("Vending Machine has shut down.");
    }

    @Override
    public String getFormattedPrice(Product product) {
        return priceRegistry.getCurrency().getSymbol() + " " + priceRegistry.getPriceForProduct(product);
    }

    @Override
    public Product[] getAvailableProducts() {
        return productList.toArray(new Product[productList.size()]);
    }

    @Override
    public void buyProduct(Product product) {
        final Set<Product> newProducts = productList.stream().filter(p -> !p.getUUID().equals(product.getUUID())).collect(Collectors.toSet());
        this.productList = newProducts;
        LOGGER.info("Product " + product.getName() + " bought for " + getFormattedPrice(product));
    }
}
