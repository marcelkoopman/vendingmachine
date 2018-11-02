package github.com.marcelkoopman.vendingmachine.product;

import github.com.marcelkoopman.vendingmachine.product.model.Beverage;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;

public class SisiNoBubbles extends Beverage {
    @Override
    protected boolean hasSoda() {
        return false;
    }

    @Override
    public Ean getEAN() {
        return Ean.valueOf("8715600234565");
    }

    @Override
    public String getName() {
        return "Strawberry No Bubbles";
    }
}
