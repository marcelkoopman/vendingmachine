package github.com.marcelkoopman.vendingmachine.product;

import java.util.UUID;

public interface Product extends Comparable<Product>{
    Ean getEAN();
    String getName();

    UUID getUUID();
    String toString();
}
