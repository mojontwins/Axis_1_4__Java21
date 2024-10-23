package javax.xml.soap;

public interface SOAPEnvelope extends SOAPElement
{
    Name createName(final String p0, final String p1, final String p2) throws SOAPException;
    
    Name createName(final String p0) throws SOAPException;
    
    SOAPHeader getHeader() throws SOAPException;
    
    SOAPBody getBody() throws SOAPException;
    
    SOAPHeader addHeader() throws SOAPException;
    
    SOAPBody addBody() throws SOAPException;
}
