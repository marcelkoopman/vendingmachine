package github.com.marcelkoopman.vendingmachine.product;

import github.com.marcelkoopman.vendingmachine.product.model.CandyBar;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;

public class MarsBar extends CandyBar {

    @Override
    public Ean getEAN() {
        return Ean.valueOf("5000159408301");
    }

    @Override
    public String getName() {
        return "Mars Bar";
    }

    @Override
    protected boolean hasCaramelIngredient() {
        return true;
    }
}
