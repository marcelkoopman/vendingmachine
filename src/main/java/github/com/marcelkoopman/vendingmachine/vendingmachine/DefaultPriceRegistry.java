package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.Ean;
import github.com.marcelkoopman.vendingmachine.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class DefaultPriceRegistry implements PriceRegistry {

    private static final Logger LOG = LogManager.getLogger(DefaultPriceRegistry.class);
    private static final Map<Ean, Double> priceList = new HashMap<>();

    static {
        priceList.put(new Ean("5000159408301"), Double.valueOf(0.75d));
    }

    @Override
    public double getPriceForProduct(Product product) {
        final Double price = priceList.get(product);
        final double priceValue;
        if (price == null || price.doubleValue() == 0d) {
            LOG.warn("Product has no registered price! Giving away for free");
            priceValue = 0d;
        } else {
            priceValue = price.doubleValue();
        }
        return priceValue;
    }
}
