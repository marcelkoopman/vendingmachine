package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.model.Product;
import github.com.marcelkoopman.vendingmachine.vendingmachine.prices.PriceRegistry;
import github.com.marcelkoopman.vendingmachine.vendingmachine.validation.VendingMachineV1Validator;
import github.com.marcelkoopman.vendingmachine.vendingmachine.validation.VendingMachineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class VendingMachineV1 implements VendingMachine {

    private static final String NAME = "V1";
    private static final Logger LOGGER = LogManager.getLogger(VendingMachineV1.class.getName());
    private final PriceRegistry priceRegistry;
    private final VendingMachineValidator validator;

    private Set<Product> productList = new TreeSet();

    public VendingMachineV1(PriceRegistry priceRegistry) {
        this.priceRegistry = priceRegistry;
        this.validator = new VendingMachineV1Validator(priceRegistry);
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
        validator.validate(products);
    }

    @Override
    public void shutDown() {
        LOGGER.info("Vending Machine has shut down.");
    }

    @Override
    public String getFormattedPrice(Product product) {
        return priceRegistry.getFormattedPrice(product);
    }

    @Override
    public Product[] getAvailableProducts() {
        return productList.toArray(new Product[productList.size()]);
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
