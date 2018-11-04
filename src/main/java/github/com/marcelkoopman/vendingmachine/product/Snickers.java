package github.com.marcelkoopman.vendingmachine.product;

import github.com.marcelkoopman.vendingmachine.product.model.CandyBar;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;

public class Snickers extends CandyBar {

    private final boolean caramel;

    private Snickers(String id, String name, Ean ean, boolean caramel) {
        this.id = id;
        this.name = name;
        this.ean = ean;
        this.caramel = caramel;
    }

    @Override
    protected boolean hasCaramelIngredient() {
        return caramel;
    }

    public static Snickers valueOf() {
        return new Snickers(ProductIdBuilder.getNextId(), "Snickers Bar", Ean.valueOf("6294001813286"), true);
    }
}
