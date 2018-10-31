package github.com.marcelkoopman.vendingmachine.api;

public interface StockRegistry {
    int getStockForProduct(Product product);
}
