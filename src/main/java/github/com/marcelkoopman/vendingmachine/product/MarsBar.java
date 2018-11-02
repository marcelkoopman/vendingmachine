package github.com.marcelkoopman.vendingmachine.product;

public class MarsBar extends AbstractProduct {

    @Override
    public Ean getEAN() {
        return Ean.valueOf("5000159408301");
    }

    @Override
    public String getName() {
        return "Mars Bar";
    }
}
