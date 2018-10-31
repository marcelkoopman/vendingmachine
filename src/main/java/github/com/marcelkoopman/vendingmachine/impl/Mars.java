package github.com.marcelkoopman.vendingmachine.impl;

import github.com.marcelkoopman.vendingmachine.api.AbstractProduct;

public class Mars extends AbstractProduct {
    private final String id, ean;

    public Mars(final String id, final String ean) {
        this.id = id;
        this.ean = ean;
    }

    @Override
    public String getId() {
        return ean;
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
