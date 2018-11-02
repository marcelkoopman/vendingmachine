package github.com.marcelkoopman.vendingmachine.product.model;

public class Doritos extends Chips {

    @Override
    protected ChipFlavour getFlavour() {
        return ChipFlavour.CORN;
    }

    @Override
    public Ean getEAN() {
        return Ean.valueOf("8710398158130");
    }

    @Override
    public String getName() {
        return "Doritos";
    }
}
