package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.model.Product;
import github.com.marcelkoopman.vendingmachine.vendingmachine.prices.PriceRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VendingMachineV1 implements VendingMachine {

    private static final String NAME = "V1";
    private static final Logger LOGGER = LogManager.getLogger(VendingMachineV1.class.getName());
    private final PriceRegistry priceRegistry;

    private Set<Product> productList = new TreeSet<>();

    public VendingMachineV1(PriceRegistry priceRegistry) {
        this.priceRegistry = priceRegistry;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean boot() {
        LOGGER.info("Vending Machine " + getName() + " is now operational.");
        return true;
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
        return priceRegistry.getFormattedPrice(product).orElse("free");
    }

    @Override
    public Stream<Product> getAllProducts() {
        return productList.stream();
    }

    @Override
    public Set<Product> getProducts() {
        return productList;
    }

    @Override
    public void buyProduct(Product product) throws VendingMachineException {
        if (productList.isEmpty()) {
            throw new VendingMachineException("Out of stock");
        } else {
            this.productList = productList.stream().filter(p -> !p.getId().equals(product.getId()))
                    .collect(Collectors.toCollection(() -> new TreeSet<>()));
            LOGGER.info("Product " + product + " bought for " + getFormattedPrice(product));
        }
    }
}
