package github.com.marcelkoopman.vendingmachine.product.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.UUID;

public abstract class AbstractProduct implements Product, Comparable<Product> {

    protected Ean ean;
    protected String name;

    protected UUID uuid = UUID.randomUUID();

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int compareTo(Product o) {
        return new CompareToBuilder()
                .append(this.ean, o.getEAN())
                .append(this.uuid, o.getUUID())
                .append(this.name, o.getName())
                .toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(ean).
                append(uuid).
                append(name).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            final Product o = (Product) obj;
            return new EqualsBuilder().append(this.ean, o.getEAN())
                    .append(this.uuid, o.getUUID())
                    .append(this.name, o.getName())
                    .isEquals();
        } else {
            return false;
        }
    }
}
