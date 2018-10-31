package github.com.marcelkoopman.vendingmachine.api;

import java.util.Map;

public interface VendingMachine {

    void boot();
    void refill();
    void shutDown();

    Map<Product, Integer> getAvailableProducts();

}
