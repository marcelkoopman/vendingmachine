import github.com.marcelkoopman.vendingmachine.product.model.Product;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineException;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineFiller;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineV1;
import github.com.marcelkoopman.vendingmachine.vendingmachine.prices.EuroRegionPrices;
import github.com.marcelkoopman.vendingmachine.vendingmachine.prices.PriceRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class VendingMachineTest {

    private static final Logger LOGGER = LogManager.getLogger(VendingMachineTest.class.getName());

    private PriceRegistry priceRegistry;
    private VendingMachineV1 vendingMachine;
    private VendingMachineFiller filler;

    @Before
    public void setUpVendingMachine() {
        priceRegistry = new EuroRegionPrices();
        vendingMachine = new VendingMachineV1(priceRegistry);
        filler = new VendingMachineFiller();

        Assert.assertTrue(vendingMachine.boot());
        Assert.assertEquals("Vending machine should be empty initially", 0, vendingMachine.getProducts().size());
    }

    @Test
    public void testSorting() {
        filler.fillVendingMachine(vendingMachine);

        final Set<Product> products = vendingMachine.getProducts();
        for (Product p : products) {
            LOGGER.info(p.getName());
        }
    }

    @Test
    public void testBuyOneProduct() throws VendingMachineException {

        final Product[] products = testRefill();

        vendingMachine.buyProduct(products[1]); // Coca Cola

        final Set<Product> availableProducts = vendingMachine.getProducts();
        Assert.assertEquals(5, availableProducts.size());
    }

    @Test(expected = VendingMachineException.class)
    public void testBuyWithOutOfStock() throws VendingMachineException {

        final Product[] products = testRefill();

        try {
            for (int i = 0; i < products.length; ++i)
                vendingMachine.buyProduct(products[i]);
        } catch (VendingMachineException e) {
            Assert.fail("Exception unexpected");
        }
        final Set<Product> availableProducts = vendingMachine.getProducts();
        Assert.assertEquals(0, availableProducts.size());

        vendingMachine.buyProduct(products[0]);
    }

    private void refillVendingMachine() {
        filler.fillVendingMachine(vendingMachine);
        final Set<Product> availableProducts = vendingMachine.getProducts();
        Assert.assertEquals("Vending machine filled with 6 products", 6, availableProducts.size());
    }


    private Product[] testRefill() {
        refillVendingMachine();

        final Product[] products = vendingMachine.getProducts().toArray(new Product[vendingMachine.getProducts().size()]);
        Assert.assertEquals("Coca Cola", products[0].getName());
        Assert.assertEquals("Doritos", products[1].getName());
        Assert.assertEquals("Doritos Sweet Chili", products[2].getName());
        Assert.assertEquals("Mars Bar", products[3].getName());
        Assert.assertEquals("Snickers Bar", products[4].getName());
        Assert.assertEquals("Strawberry No Bubbles", products[5].getName());
        return products;
    }

}
