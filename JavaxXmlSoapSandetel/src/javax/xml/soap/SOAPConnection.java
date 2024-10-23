package javax.xml.soap;

public abstract class SOAPConnection
{
    public abstract SOAPMessage call(final SOAPMessage p0, final Object p1) throws SOAPException;
    
    public SOAPMessage get(final Object to) throws SOAPException {
        throw new UnsupportedOperationException("All subclasses of SOAPConnection must override get()");
    }
    
    public abstract void close() throws SOAPException;
}
