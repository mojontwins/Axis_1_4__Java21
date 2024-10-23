package javax.xml.rpc.holders;

import java.math.*;

public final class BigIntegerHolder implements Holder
{
    public BigInteger value;
    
    public BigIntegerHolder() {
    }
    
    public BigIntegerHolder(final BigInteger myBigInteger) {
        this.value = myBigInteger;
    }
}
