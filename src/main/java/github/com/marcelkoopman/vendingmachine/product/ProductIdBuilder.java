package github.com.marcelkoopman.vendingmachine.product;

import java.util.UUID;

public class ProductIdBuilder {

    public static String getNextId() {
        final String id = String.valueOf(UUID.randomUUID());
        return id;
    }
}
