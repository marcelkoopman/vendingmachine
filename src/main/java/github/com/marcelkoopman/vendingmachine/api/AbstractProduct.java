package github.com.marcelkoopman.vendingmachine.api;

public abstract class AbstractProduct implements Product {

    @Override
    public abstract String getId();

    @Override
    public abstract String getEAN();

    @Override
    public abstract String getName();

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("id: ");
        builder.append(getId());
        builder.append(", ");
        builder.append("ean: ");
        builder.append(getEAN());
        builder.append(", ");
        builder.append("name: ");
        builder.append(getName());
        return builder.toString();
    }

    @Override
    public int compareTo(Product o) {
        return o.getId().compareTo(getId());
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
