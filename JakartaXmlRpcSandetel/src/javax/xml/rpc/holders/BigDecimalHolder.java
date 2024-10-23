package javax.xml.rpc.holders;

import java.math.*;

public final class BigDecimalHolder implements Holder
{
    public BigDecimal value;
    
    public BigDecimalHolder() {
    }
    
    public BigDecimalHolder(final BigDecimal myBigDecimal) {
        this.value = myBigDecimal;
    }
}
