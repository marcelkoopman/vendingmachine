package github.com.marcelkoopman.vendingmachine.product.model;

public interface Product {
    Ean getEAN();

    String getName();

    String getId();

    String toString();
}
