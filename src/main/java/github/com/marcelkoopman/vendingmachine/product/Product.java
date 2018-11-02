package github.com.marcelkoopman.vendingmachine.product;

public interface Product extends Comparable<Product>{
    Ean getEAN();
    String getName();
    String toString();
}
