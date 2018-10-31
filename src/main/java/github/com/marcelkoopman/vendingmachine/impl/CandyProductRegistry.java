package github.com.marcelkoopman.vendingmachine.impl;

import github.com.marcelkoopman.vendingmachine.api.Product;
import github.com.marcelkoopman.vendingmachine.api.ProductRegistry;

import java.util.Set;
import java.util.TreeSet;

public class CandyProductRegistry implements ProductRegistry {

    @Override
    public Set<Product> getProducts() {
        final Set<Product> products = new TreeSet<>();
        products.add(new Mars("1","A"));
        products.add(new Mars("2", "B"));
        return products;
    }
}
