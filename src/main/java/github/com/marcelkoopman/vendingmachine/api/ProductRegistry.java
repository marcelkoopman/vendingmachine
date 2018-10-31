package github.com.marcelkoopman.vendingmachine.api;

import java.util.Set;

public interface ProductRegistry {
    Set<Product> getProducts(); // Product than can be sold in vending machines
}
