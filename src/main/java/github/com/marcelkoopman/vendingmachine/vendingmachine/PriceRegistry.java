package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.Product;

import java.util.Currency;

public interface PriceRegistry {
    double getPriceForProduct(Product product);

    Currency getCurrency();
}
