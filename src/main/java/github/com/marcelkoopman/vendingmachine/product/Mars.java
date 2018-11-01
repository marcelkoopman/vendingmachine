package github.com.marcelkoopman.vendingmachine.product;

public class Mars extends AbstractProduct {
    private final String id, ean;

    public Mars(final String id, final String ean) {
        this.id = id;
        this.ean = ean;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getEAN() {
        return ean;
    }

    @Override
    public String getName() {
        return "Mars "+getEAN();
    }
}
