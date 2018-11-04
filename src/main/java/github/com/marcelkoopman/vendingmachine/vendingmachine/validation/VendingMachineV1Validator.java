package github.com.marcelkoopman.vendingmachine.vendingmachine.validation;

import github.com.marcelkoopman.vendingmachine.product.model.Product;
import github.com.marcelkoopman.vendingmachine.vendingmachine.prices.PriceRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

public class VendingMachineV1Validator implements VendingMachineValidator {

    private static final Logger LOGGER = LogManager.getLogger(VendingMachineValidator.class.getName());
    private final PriceRegistry priceRegistry;

    public VendingMachineV1Validator(PriceRegistry priceRegistry) {
        this.priceRegistry = priceRegistry;
    }

    public void validate(Collection<Product> products) {
        products.stream().forEach(p -> validate(p));
    }

    public void validate(Product product) {
        if (priceRegistry.getPriceForProduct(product) == 0.0d) {
            LOGGER.warn("Product " + product + " found without price set!, check price registry " + priceRegistry.getClass().getSimpleName());
        }
    }
}
