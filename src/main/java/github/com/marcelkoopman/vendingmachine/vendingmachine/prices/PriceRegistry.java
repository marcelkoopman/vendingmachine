package github.com.marcelkoopman.vendingmachine.vendingmachine.prices;

import github.com.marcelkoopman.vendingmachine.product.model.Product;

import java.util.Currency;
import java.util.Optional;

public interface PriceRegistry {

    /**
     * Price for this product
     *
     * @param product
     * @return price
     */
    Optional<Double> getPriceForProduct(Product product);

    /**
     * Currency in which prices are noted
     *
     * @return Currency
     */
    Optional<Currency> getCurrency();

    Optional<String> getFormattedPrice(Product product);
}
