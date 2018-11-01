package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.Product;

public interface PriceRegistry {
    double getPriceForProduct(Product product);
}
