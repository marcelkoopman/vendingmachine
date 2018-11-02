import github.com.marcelkoopman.vendingmachine.vendingmachine.PriceRegistry;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineV1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class VendingMachineTest {

    @Test
    public void testVendingMachineBoot() {
        final PriceRegistry priceRegistry = Mockito.mock(PriceRegistry.class);
        final VendingMachineV1 vendingMachine = new VendingMachineV1(priceRegistry);
        Assert.assertTrue(vendingMachine.boot());
    }
}
