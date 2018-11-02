package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.MarsBar;
import github.com.marcelkoopman.vendingmachine.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashSet;

public class VendingMachineFiller {

    private static final Logger LOG = LogManager.getLogger(VendingMachineFiller.class);
    private static final Collection<Product> products = new HashSet<>();

    static {
        products.add(new MarsBar());
        products.add(new MarsBar());
        products.add(new MarsBar());
        products.add(new MarsBar());
    }

    public void fillVendingMachine(VendingMachine vendingMachine) {
        LOG.info("Filling vendingmachine " + vendingMachine.getName() + " with " + products.size() + " products.");
        vendingMachine.refill(products);
    }
}
