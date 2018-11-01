package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.Product;

import java.util.Map;

public interface VendingMachine {

    void boot();
    void refill();
    void shutDown();

    Map<Product, Integer> getAvailableProducts();

}
