package github.com.marcelkoopman.vendingmachine.api;

public interface Product extends Comparable<Product>{
    String getId();
    String getEAN();
    String getName();
}
