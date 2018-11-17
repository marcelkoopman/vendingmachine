package github.com.marcelkoopman.vendingmachine.vendingmachine.prices;

import github.com.marcelkoopman.vendingmachine.product.model.Ean;
import github.com.marcelkoopman.vendingmachine.product.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class EuroRegionPrices implements PriceRegistry {

    private static final Logger LOG = LogManager.getLogger(EuroRegionPrices.class);
    private static final Map<Ean, Optional<Double>> priceList = new HashMap<>();

    static {
        priceList.put(Ean.valueOf("5000159408301"), of(0.75d));
        priceList.put(Ean.valueOf("6294001813286"), of(0.65d));
        priceList.put(Ean.valueOf("8715600234565"), of(0.70d));
        priceList.put(Ean.valueOf("8710398158130"), of(1.50d));
        priceList.put(Ean.valueOf("1535589200415"), empty());
    }

    private final NumberFormat formatter = new DecimalFormat("#0.00");

    @Override
    public Optional<Double> getPriceForProduct(Product product) {
        return priceList.entrySet().stream().filter(p -> p.getKey().equals(product.getEAN())).findFirst().flatMap(p -> p.getValue());
    }

    @Override
    public Optional<Currency> getCurrency() {
        final Currency currency = Currency.getInstance(Locale.getDefault());
        final Optional<Currency> result;
        if (currency == null) {
            result = empty();
        } else {
            result = of(currency);
        }
        return result;
    }

    @Override
    public Optional<String> getFormattedPrice(Product product) {
        return this.getCurrency().map(
                c -> getPriceForProduct(product).map(
                        p -> c.getSymbol() + " " + formatter.format(p))
        ).flatMap(p -> p);
    }
}
