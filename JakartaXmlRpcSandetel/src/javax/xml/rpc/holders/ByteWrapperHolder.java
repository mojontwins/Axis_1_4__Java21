package javax.xml.rpc.holders;

public final class ByteWrapperHolder implements Holder
{
    public Byte value;
    
    public ByteWrapperHolder() {
    }
    
    public ByteWrapperHolder(final Byte mybyte) {
        this.value = mybyte;
    }
}
