package github.com.marcelkoopman.vendingmachine.vendingmachine.validation;

import github.com.marcelkoopman.vendingmachine.product.model.Product;

import java.util.Collection;

public interface VendingMachineValidator {

    void validate(Collection<Product> products);

    void validate(Product product);
}
