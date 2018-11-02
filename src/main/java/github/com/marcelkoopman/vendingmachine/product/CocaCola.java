package github.com.marcelkoopman.vendingmachine.product;

import github.com.marcelkoopman.vendingmachine.product.model.Beverage;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;

public class CocaCola extends Beverage {

    @Override
    public Ean getEAN() {
        return Ean.valueOf("1535589200415");
    }

    @Override
    public String getName() {
        return "Coca Cola";
    }

    @Override
    protected boolean hasSoda() {
        return true;
    }

    @Override
    protected boolean containsAlcohol() {
        return false;
    }


}
