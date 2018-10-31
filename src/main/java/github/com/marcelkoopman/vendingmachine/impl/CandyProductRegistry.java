package github.com.marcelkoopman.vendingmachine.impl;

import github.com.marcelkoopman.vendingmachine.api.Product;
import github.com.marcelkoopman.vendingmachine.api.ProductRegistry;

import java.util.Set;
import java.util.TreeSet;

public class CandyProductRegistry implements ProductRegistry {

    @Override
    public Set<Product> getProducts() {
        final Set<Product> products = new TreeSet<Product>();
        products.add(new Product() {
            @Override
            public int compareTo(Product o) {
                return o.getName().compareTo(this.getName());
            }

            @Override
            public String getId() {
                return null;
            }

            @Override
            public String getEAN() {
                return null;
            }

            @Override
            public String getName() {
                return "P1";
            }
        });
        return products;
    }
}
