package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.model.Product;

import java.util.Collection;

public interface VendingMachine {

    String getName();
    void boot();

    void refill(Collection<Product> products);

    void shutDown();

    String getFormattedPrice(Product product);

    Product[] getAvailableProducts();

    void buyProduct(Product product);
}
