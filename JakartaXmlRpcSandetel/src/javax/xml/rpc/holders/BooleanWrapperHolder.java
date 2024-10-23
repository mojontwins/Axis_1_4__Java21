package javax.xml.rpc.holders;

public final class BooleanWrapperHolder implements Holder
{
    public Boolean value;
    
    public BooleanWrapperHolder() {
    }
    
    public BooleanWrapperHolder(final Boolean myboolean) {
        this.value = myboolean;
    }
}
