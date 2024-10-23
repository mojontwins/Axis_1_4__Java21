package javax.xml.rpc.holders;

public final class FloatWrapperHolder implements Holder
{
    public Float value;
    
    public FloatWrapperHolder() {
    }
    
    public FloatWrapperHolder(final Float myfloat) {
        this.value = myfloat;
    }
}
