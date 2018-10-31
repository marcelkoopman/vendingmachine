package github.com.marcelkoopman.vendingmachine.api;

import java.util.Set;

public interface VendingMachine {

    void boot();
    void shutDown();

    Set<Product> getAvailableProducts();

}
