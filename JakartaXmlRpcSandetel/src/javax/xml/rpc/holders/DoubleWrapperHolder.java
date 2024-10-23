package javax.xml.rpc.holders;

public final class DoubleWrapperHolder implements Holder
{
    public Double value;
    
    public DoubleWrapperHolder() {
    }
    
    public DoubleWrapperHolder(final Double mydouble) {
        this.value = mydouble;
    }
}
