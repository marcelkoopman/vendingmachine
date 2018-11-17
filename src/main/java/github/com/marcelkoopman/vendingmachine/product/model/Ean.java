package github.com.marcelkoopman.vendingmachine.product.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An EAN code is an unique identifier for products
 */
public class Ean implements Comparable<Ean> {

    private String ean;

    private Ean(String ean) {
        this.ean = ean;
    }

    public String getEan() {
        return this.ean;
    }

    public static Ean valueOf(String ean) {
        return new Ean(ean);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
            var o = (Ean) obj;
            return new EqualsBuilder().append(this.ean, o.getEan()).isEquals();
        } else {
            return false;
        }
    }
}
