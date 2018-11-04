package github.com.marcelkoopman.vendingmachine.product;

import github.com.marcelkoopman.vendingmachine.product.model.Beverage;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;

public class CocaCola extends Beverage {

    private CocaCola(String id, String name, Ean ean, boolean hasSoda, boolean containsAlcohol) {
        this.id = id;
        this.name = name;
        this.ean = ean;
        this.soda = hasSoda;
        this.alcohol = containsAlcohol;
    }

    public static CocaCola valueOf() {
        return new CocaCola(ProductIdBuilder.getNextId(), "Coca Cola", Ean.valueOf("1535589200415"), true, false);
    }

}
