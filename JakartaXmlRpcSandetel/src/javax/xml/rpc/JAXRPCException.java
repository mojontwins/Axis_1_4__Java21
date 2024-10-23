package javax.xml.rpc;

public class JAXRPCException extends RuntimeException
{
    private static final long serialVersionUID = 5213579554532711730L;
	private Throwable cause;
    
    public JAXRPCException() {
        this.cause = null;
    }
    
    public JAXRPCException(final String message) {
        super(message);
        this.cause = null;
    }
    
    public JAXRPCException(final String message, final Throwable cause) {
        super(message);
        this.cause = cause;
    }
    
    public JAXRPCException(final Throwable cause) {
        super((cause == null) ? null : cause.toString());
        this.cause = cause;
    }
    
    public Throwable getLinkedCause() {
        return this.cause;
    }
}
