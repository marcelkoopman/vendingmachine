package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.model.Product;

import java.util.Collection;

public interface VendingMachine {

    String getName();

    /**
     * Boot the vending machine in operational mode
     *
     * @return true if successful
     */
    boolean boot();

    /**
     * Refill with new products, meaning adding when non existent
     *
     * @param products
     */
    void refill(Collection<Product> products);

    void shutDown();

    /**
     * Get the formatted price with Currency information
     *
     * @param product
     * @return String formatted price
     */
    String getFormattedPrice(Product product);

    Product[] getAvailableProducts();

    /**
     * Purchase selected product
     *
     * @param product
     */
    void buyProduct(Product product);
}
