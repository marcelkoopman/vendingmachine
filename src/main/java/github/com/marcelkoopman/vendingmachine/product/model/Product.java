package github.com.marcelkoopman.vendingmachine.product.model;

import java.util.UUID;

public interface Product extends Comparable<Product>{
    Ean getEAN();
    String getName();

    UUID getUUID();
    String toString();
}
