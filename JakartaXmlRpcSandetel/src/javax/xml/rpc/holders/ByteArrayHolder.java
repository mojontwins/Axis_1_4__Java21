package javax.xml.rpc.holders;

public final class ByteArrayHolder implements Holder
{
    public byte[] value;
    
    public ByteArrayHolder() {
    }
    
    public ByteArrayHolder(final byte[] mybyteArray) {
        this.value = mybyteArray;
    }
}
