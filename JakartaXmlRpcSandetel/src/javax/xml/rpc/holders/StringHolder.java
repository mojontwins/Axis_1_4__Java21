package javax.xml.rpc.holders;

public final class StringHolder implements Holder
{
    public String value;
    
    public StringHolder() {
    }
    
    public StringHolder(final String myString) {
        this.value = myString;
    }
}
