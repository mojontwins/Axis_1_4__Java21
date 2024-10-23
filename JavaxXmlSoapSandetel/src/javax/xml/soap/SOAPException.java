package javax.xml.soap;

public class SOAPException extends Exception
{
    private static final long serialVersionUID = 5083961510786058130L;
	private Throwable cause;
    
    public SOAPException() {
        this.cause = null;
    }
    
    public SOAPException(final String reason) {
        super(reason);
        this.cause = null;
    }
    
    public SOAPException(final String reason, final Throwable cause) {
        super(reason);
        this.initCause(cause);
    }
    
    public SOAPException(final Throwable cause) {
        super(cause.toString());
        this.initCause(cause);
    }
    
    @Override
    public String getMessage() {
        final String message = super.getMessage();
        if (message == null && this.cause != null) {
            return this.cause.getMessage();
        }
        return message;
    }
    
    @Override
    public Throwable getCause() {
        return this.cause;
    }
    
    @Override
    public synchronized Throwable initCause(final Throwable cause) {
        if (this.cause != null) {
            throw new IllegalStateException("Can't override cause");
        }
        if (cause == this) {
            throw new IllegalArgumentException("Self-causation not permitted");
        }
        this.cause = cause;
        return this;
    }
}
