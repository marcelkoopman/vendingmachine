package github.com.marcelkoopman.vendingmachine.api;

import java.util.Map;

public interface StockRegistry {
    void stockProduct(Product product);
    int getStockForProduct(Product product);
    Map<Product, Integer> getProductsInStock();
    int sellProduct(Product product);
}
