package github.com.marcelkoopman.vendingmachine.product;

public class Snickers extends AbstractProduct {

    @Override
    public Ean getEAN() {
        return Ean.valueOf("6294001813286");
    }

    @Override
    public String getName() {
        return "Snickers Bar";
    }
}
