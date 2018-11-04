package github.com.marcelkoopman.vendingmachine.product.model;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class Chips extends AbstractProduct {

    protected abstract ChipFlavour getFlavour();

    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("name", getName()).
                append("flavour", getFlavour()).
                toString();
    }
}
