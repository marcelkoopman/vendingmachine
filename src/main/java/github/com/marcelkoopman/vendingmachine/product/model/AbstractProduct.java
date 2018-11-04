package github.com.marcelkoopman.vendingmachine.product.model;

import org.apache.commons.lang3.builder.*;

public abstract class AbstractProduct implements Product, Comparable<Product> {

    protected Ean ean;
    protected String name;

    protected String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Ean getEAN() {
        return ean;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Product o) {
        return new CompareToBuilder()
                .append(this.ean, o.getEAN())
                .append(this.id, o.getId())
                .append(this.name, o.getName())
                .toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(ean).
                append(id).
                append(name).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            final Product o = (Product) obj;
            return new EqualsBuilder().append(this.ean, o.getEAN())
                    .append(this.id, o.getId())
                    .append(this.name, o.getName())
                    .isEquals();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("name", getName()).
                append("id", getId()).
                toString();
    }
}
