package github.com.marcelkoopman.vendingmachine.product;

import github.com.marcelkoopman.vendingmachine.product.model.Beverage;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;

public class SisiNoBubbles extends Beverage {

    private SisiNoBubbles(String id, String name, Ean ean, boolean hasSoda, boolean containsAlcohol) {
        this.id = id;
        this.name = name;
        this.ean = ean;
        this.soda = hasSoda;
        this.alcohol = containsAlcohol;
    }

    public static SisiNoBubbles valueOf() {
        return new SisiNoBubbles(ProductIdBuilder.getNextId(), "Strawberry No Bubbles", Ean.valueOf("8715600234565"), false, false);
    }
}
