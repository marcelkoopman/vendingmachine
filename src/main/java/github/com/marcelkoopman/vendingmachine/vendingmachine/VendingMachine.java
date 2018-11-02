package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.Product;

import java.util.Collection;
import java.util.Map;

public interface VendingMachine {

    String getName();
    void boot();

    void refill(Collection<Product> products);
    void shutDown();

    String getFormattedPrice(Product product);

    Map<Product, Integer> getAvailableProducts();

}
