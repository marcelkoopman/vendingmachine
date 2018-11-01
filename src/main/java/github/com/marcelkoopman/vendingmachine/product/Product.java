package github.com.marcelkoopman.vendingmachine.product;

public interface Product extends Comparable<Product>{
    String getId();
    String getEAN();
    String getName();

    String toString();
}
