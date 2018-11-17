package github.com.marcelkoopman.vendingmachine.vendingmachine;

import github.com.marcelkoopman.vendingmachine.product.*;
import github.com.marcelkoopman.vendingmachine.product.model.ChipFlavour;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;
import github.com.marcelkoopman.vendingmachine.product.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.TreeSet;

/**
 * A VendingMachine "filler" fills the vendng machine with products.
 */
public class VendingMachineFiller {

    private static final Logger LOG = LogManager.getLogger(VendingMachineFiller.class);
    private final ProductIdBuilder productBuilder = new ProductIdBuilder();

    private Collection<Product> buildProducts() {
        Collection<Product> products = new TreeSet<>();
        products.add(Doritos.valueOf("Doritos", Ean.valueOf("8710398158130"), ChipFlavour.CORN));
        products.add(CocaCola.valueOf());
        products.add(SisiNoBubbles.valueOf());
        products.add(MarsBar.valueOf());
        products.add(Snickers.valueOf());
        products.add(Doritos.valueOf("Doritos Sweet Chili",
                Ean.valueOf("8710398603319"), ChipFlavour.SWEET_CHILLI_PEPPER));
        return products;
    }

    public void fillVendingMachine(VendingMachine vendingMachine) {
        buildProducts();
        LOG.info("Filling vendingmachine " + vendingMachine.getName() + " with " + buildProducts().size() + " products.");
        vendingMachine.refill(buildProducts());
    }
}
