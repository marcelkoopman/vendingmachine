package github.com.marcelkoopman.vendingmachine.vendingmachine.prices;

import github.com.marcelkoopman.vendingmachine.product.model.Product;

import java.util.Currency;

public interface PriceRegistry {

    /**
     * Price for this product
     *
     * @param product
     * @return price
     */
    double getPriceForProduct(Product product);

    /**
     * Currency in which prices are noted
     *
     * @return Currency
     */
    Currency getCurrency();

    String getFormattedPrice(Product product);
}
