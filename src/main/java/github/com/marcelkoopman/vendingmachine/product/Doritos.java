package github.com.marcelkoopman.vendingmachine.product;

import github.com.marcelkoopman.vendingmachine.product.model.ChipFlavour;
import github.com.marcelkoopman.vendingmachine.product.model.Chips;
import github.com.marcelkoopman.vendingmachine.product.model.Ean;

public class Doritos extends Chips {

    private ChipFlavour flavour;
    private String name;
    private Ean ean;

    private Doritos(String id, String name, Ean ean, ChipFlavour flavour) {
        this.id = id;
        this.name = name;
        this.ean = ean;
        this.flavour = flavour;
    }

    @Override
    protected ChipFlavour getFlavour() {
        return flavour;
    }

    @Override
    public Ean getEAN() {
        return ean;
    }

    @Override
    public String getName() {
        return name;
    }

    public static Doritos valueOf(String name, Ean ean, ChipFlavour flavour) {
        return new Doritos(ProductIdBuilder.getNextId(), name, ean, flavour);
    }
}
