package javax.xml.rpc;

public class ServiceException extends Exception
{
    private static final long serialVersionUID = -6582148924441189775L;
	private Throwable cause;
    
    public ServiceException() {
        this.cause = null;
    }
    
    public ServiceException(final String message) {
        super(message);
        this.cause = null;
    }
    
    public ServiceException(final String message, final Throwable cause) {
        super(message);
        this.cause = cause;
    }
    
    public ServiceException(final Throwable cause) {
        super((cause == null) ? null : cause.toString());
        this.cause = cause;
    }
    
    public Throwable getLinkedCause() {
        return this.cause;
    }
}
