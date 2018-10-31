package github.com.marcelkoopman.vendingmachine.impl;

import github.com.marcelkoopman.vendingmachine.api.Product;
import github.com.marcelkoopman.vendingmachine.api.StockRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class DefaultStockRegistry implements StockRegistry {

    private static final Logger LOGGER = LogManager.getLogger(DefaultStockRegistry.class.getName());

    private final Map<Product, Integer> productStock = new HashMap<>();

    @Override
    public void stockProduct(Product product) {
        if (productStock.containsKey(product)) {
            final Integer currentStock = productStock.get(product);
            productStock.put(product, currentStock + 1);
            LOGGER.info("Stocked more products of {} now {} in total. ", product.getName(), currentStock + 1);
        } else {
            productStock.put(product, 1);
            LOGGER.info("Stocked product: " + product);
        }

    }

    @Override
    public int getStockForProduct(Product product) {
        return productStock.get(product);
    }

    @Override
    public Map<Product, Integer> getProductsInStock() {
        return productStock; //.entrySet().stream().filter( x -> x.getValue().intValue() > 0).map( x -> x.getKey() ).collect(Collectors.toSet());
    }

    @Override
    public int sellProduct(Product product) {
        final Integer currentStock = productStock.get(product);
        final Integer result;
        if (currentStock == null || currentStock.intValue() == 0) {
            result = 0;
        } else {
            result = productStock.put(product, currentStock.intValue() - 1);

        }
        return result;
    }
}
