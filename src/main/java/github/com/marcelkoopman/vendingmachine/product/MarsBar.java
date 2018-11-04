package github.com.marcelkoopman.vendingmachine.product;

import github.com.marcelkoopman.vendingmachine.product.model.CandyBar;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;

public class MarsBar extends CandyBar {

    private final boolean caramel;

    private MarsBar(String id, String name, Ean ean, boolean caramel) {
        this.id = id;
        this.name = name;
        this.ean = ean;
        this.caramel = caramel;
    }

    @Override
    protected boolean hasCaramelIngredient() {
        return caramel;
    }

    public static MarsBar valueOf() {
        return new MarsBar(ProductIdBuilder.getNextId(), "Mars Bar", Ean.valueOf("5000159408301"), true);
    }
}
