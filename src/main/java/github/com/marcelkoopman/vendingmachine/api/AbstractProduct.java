package github.com.marcelkoopman.vendingmachine.api;

public abstract class AbstractProduct implements Product {

    @Override
    public abstract String getId();

    @Override
    public abstract String getEAN();

    @Override
    public abstract String getName();

    @Override
    public int compareTo(Product o) {
        return o.getName().compareTo(getName());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        final boolean equals;
        if (obj instanceof Product) {
            final Product otherProduct = (Product) obj;
            equals = getName().equals(otherProduct.getName())
            && getId().equals(otherProduct.getId()) &&
                    getEAN().equals(otherProduct.getEAN());
        } else {
            equals = false;
        }
        return equals;
    }
}
