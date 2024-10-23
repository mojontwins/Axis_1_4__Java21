package javax.xml.rpc.holders;

public final class IntegerWrapperHolder implements Holder
{
    public Integer value;
    
    public IntegerWrapperHolder() {
    }
    
    public IntegerWrapperHolder(final Integer myint) {
        this.value = myint;
    }
}
