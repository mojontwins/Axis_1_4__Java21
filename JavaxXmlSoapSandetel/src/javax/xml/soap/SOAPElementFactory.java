package javax.xml.soap;

public class SOAPElementFactory
{
    private SOAPFactory soapFactory;
    
    private SOAPElementFactory(final SOAPFactory soapFactory) {
        this.soapFactory = soapFactory;
    }
    
    @Deprecated
    public SOAPElement create(final Name name) throws SOAPException {
        return this.soapFactory.createElement(name);
    }
    
    @Deprecated
    public SOAPElement create(final String localName) throws SOAPException {
        return this.soapFactory.createElement(localName);
    }
    
    @Deprecated
    public SOAPElement create(final String localName, final String prefix, final String uri) throws SOAPException {
        return this.soapFactory.createElement(localName, prefix, uri);
    }
    
    public static SOAPElementFactory newInstance() throws SOAPException {
        try {
            return new SOAPElementFactory(SOAPFactory.newInstance());
        }
        catch (Exception ex) {
            throw new SOAPException("Unable to create SOAP Element Factory: " + ex.getMessage());
        }
    }
}
