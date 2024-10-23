package javax.xml.rpc.holders;

public final class BooleanHolder implements Holder
{
    public boolean value;
    
    public BooleanHolder() {
    }
    
    public BooleanHolder(final boolean myboolean) {
        this.value = myboolean;
    }
}
