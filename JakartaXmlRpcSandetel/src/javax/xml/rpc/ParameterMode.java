package javax.xml.rpc;

public class ParameterMode
{
    private final String mode;
    public static final ParameterMode IN;
    public static final ParameterMode OUT;
    public static final ParameterMode INOUT;
    
    private ParameterMode(final String mode) {
        this.mode = mode;
    }
    
    @Override
    public String toString() {
        return this.mode;
    }
    
    static {
        IN = new ParameterMode("IN");
        OUT = new ParameterMode("OUT");
        INOUT = new ParameterMode("INOUT");
    }
}
