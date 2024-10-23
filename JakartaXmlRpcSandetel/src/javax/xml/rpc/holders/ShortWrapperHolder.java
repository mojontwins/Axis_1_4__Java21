package javax.xml.rpc.holders;

public final class ShortWrapperHolder implements Holder
{
    public Short value;
    
    public ShortWrapperHolder() {
    }
    
    public ShortWrapperHolder(final Short myshort) {
        this.value = myshort;
    }
}
