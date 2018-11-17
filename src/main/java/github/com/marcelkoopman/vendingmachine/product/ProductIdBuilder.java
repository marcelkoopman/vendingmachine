package github.com.marcelkoopman.vendingmachine.product;

import java.util.UUID;

public class ProductIdBuilder {

    public static String getNextId() {
        return String.valueOf(UUID.randomUUID());
    }
}
