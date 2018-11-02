package github.com.marcelkoopman.vendingmachine.product;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * An EAN code is an unique identifier for products
 */
public class Ean implements Comparable<Ean> {

    private String ean;

    public Ean(String ean) {
        this.ean = ean;
    }

    public String getEan() {
        return this.ean;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ean: ");
        builder.append(getEan());
        return builder.toString();
    }

    @Override
    public int compareTo(Ean o) {
        return new CompareToBuilder()
                .append(this.ean, o.getEan())
                .toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(ean).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ean) {
            final Ean o = (Ean) obj;
            return new EqualsBuilder().append(this.ean, o.getEan()).isEquals();
        } else {
            return false;
        }
    }
}
