package github.com.marcelkoopman.vendingmachine.api;

public interface PriceRegistry {
    double getPriceForProduct(Product product);
}
