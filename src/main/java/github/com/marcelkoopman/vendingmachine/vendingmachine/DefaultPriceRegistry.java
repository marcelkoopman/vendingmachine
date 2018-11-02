package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.model.Ean;
import github.com.marcelkoopman.vendingmachine.product.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DefaultPriceRegistry implements PriceRegistry {

    private static final Logger LOG = LogManager.getLogger(DefaultPriceRegistry.class);
    private static final Map<Ean, Double> priceList = new HashMap<>();

    static {
        priceList.put(Ean.valueOf("5000159408301"), 0.75d);
        priceList.put(Ean.valueOf("6294001813286"), 0.65d);
    }

    @Override
    public double getPriceForProduct(Product product) {
        final Double price = priceList.get(product.getEAN());
        final double priceValue;
        if (price == null || price.doubleValue() == 0d) {
            LOG.warn("Product has no registered price! Giving away for free");
            priceValue = 0d;
        } else {
            priceValue = price.doubleValue();
        }
        return priceValue;
    }

    @Override
    public Currency getCurrency() {
        return Currency.getInstance(Locale.getDefault());
    }
}
