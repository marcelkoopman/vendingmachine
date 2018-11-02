package github.com.marcelkoopman.vendingmachine.product.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class Beverage extends AbstractProduct {

    protected abstract boolean hasSoda();

    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("name", getName()).
                append("ean", getEAN().getEan()).
                append("soda", hasSoda()).
                toString();
    }

}
