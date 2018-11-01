package github.com.marcelkoopman.vendingmachine.product;

public class Mars extends AbstractProduct {

    public Mars(final String id, final String ean) {
        this.id = id;
        this.ean = ean;
    }

    @Override
    public String getName() {
        return "Mars "+getEAN();
    }
}
