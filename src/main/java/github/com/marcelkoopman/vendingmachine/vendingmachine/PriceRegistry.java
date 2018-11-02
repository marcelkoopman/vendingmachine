package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.model.Product;

import java.util.Currency;

public interface PriceRegistry {
    double getPriceForProduct(Product product);

    Currency getCurrency();
}
