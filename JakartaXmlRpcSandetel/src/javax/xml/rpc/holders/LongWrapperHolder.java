package javax.xml.rpc.holders;

public final class LongWrapperHolder implements Holder
{
    public Long value;
    
    public LongWrapperHolder() {
    }
    
    public LongWrapperHolder(final Long mylong) {
        this.value = mylong;
    }
}
