package github.com.marcelkoopman.vendingmachine.product;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class AbstractProduct implements Product, Comparable<Product> {

    protected Ean ean;
    protected String name;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ean: ");
        builder.append(getEAN());
        builder.append("name: ");
        builder.append(getName());
        return builder.toString();
    }

    @Override
    public int compareTo(Product o) {
        return new CompareToBuilder()
                .append(this.ean, o.getEAN())
                .append(this.name, o.getName())
                .toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(ean).
                append(name).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            final Product o = (Product) obj;
            return new EqualsBuilder().append(this.ean, o.getEAN())
                    .append(this.name, o.getName())
                    .isEquals();
        } else {
            return false;
        }
    }
}
