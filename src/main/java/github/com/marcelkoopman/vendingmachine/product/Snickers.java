package github.com.marcelkoopman.vendingmachine.product;

import github.com.marcelkoopman.vendingmachine.product.model.CandyBar;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;

public class Snickers extends CandyBar {

    @Override
    public Ean getEAN() {
        return Ean.valueOf("6294001813286");
    }

    @Override
    public String getName() {
        return "Snickers Bar";
    }

    @Override
    protected boolean hasCaramelIngredient() {
        return true;
    }
}
