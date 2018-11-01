package github.com.marcelkoopman.vendingmachine.product;

import java.security.SecureRandom;
import java.util.Set;
import java.util.TreeSet;

public class CandyProductRegistry implements ProductRegistry {

    @Override
    public Set<Product> getProducts() {
        final Set<Product> products = new TreeSet<>();
        products.add(new Mars(generateId(), "A"));
        products.add(new Mars(generateId(), "B"));
        products.add(new Mars(generateId(), "B"));
        products.add(new Mars(generateId(), "B"));
        products.add(new Mars(generateId(), "A"));
        return products;
    }

    private final String generateId() {
        final String id = "" + new SecureRandom().nextInt(2048);
        System.out.println(id);
        return id;
    }
}
