package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.Ean;
import github.com.marcelkoopman.vendingmachine.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class DefaultStockRegistry implements StockRegistry {

    private static final Logger LOGGER = LogManager.getLogger(DefaultStockRegistry.class.getName());

    private final Map<Ean, Integer> productStock = new HashMap<>();

    @Override
    public void stockProduct(Product product) {
        if (productStock.containsKey(product.getEAN())) {
            final Integer currentStock = productStock.get(product.getEAN());
            productStock.put(product.getEAN(), currentStock + 1);
            LOGGER.info("Stocked more products of {} now {} in total. ", product.getEAN(), currentStock + 1);
        } else {
            productStock.put(product.getEAN(), 1);
            LOGGER.info("Stocked product: " + product);
        }

    }

    @Override
    public int getStockForProduct(Product product) {
        return productStock.get(product);
    }

    @Override
    public Map<Product, Integer> getProductsInStock() {
        return null;
        //return productStock; //.entrySet().stream().filter( x -> x.getValue().intValue() > 0).map( x -> x.getKey() ).collect(Collectors.toSet());
    }

    @Override
    public int sellProduct(Product product) {
        final Integer currentStock = productStock.get(product);
        final Integer result;
        if (currentStock == null || currentStock.intValue() == 0) {
            result = 0;
        } else {
            result = productStock.put(product.getEAN(), currentStock.intValue() - 1);

        }
        return result;
    }
}
