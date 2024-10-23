package javax.xml.rpc.holders;

public final class ObjectHolder implements Holder
{
    public Object value;
    
    public ObjectHolder() {
    }
    
    public ObjectHolder(final Object value) {
        this.value = value;
    }
}
