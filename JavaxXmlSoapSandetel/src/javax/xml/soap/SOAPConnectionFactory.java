package javax.xml.soap;

public abstract class SOAPConnectionFactory
{
    @SuppressWarnings("unused")
	private static final String DEFAULT_SOAP_CONNECTION_FACTORY = "com.sun.xml.internal.messaging.saaj.client.p2p.HttpSOAPConnectionFactory";
    
    public static SOAPConnectionFactory newInstance() throws SOAPException, UnsupportedOperationException {
        try {
            return FactoryFinder.find(SOAPConnectionFactory.class, "com.sun.xml.internal.messaging.saaj.client.p2p.HttpSOAPConnectionFactory", true);
        }
        catch (Exception ex) {
            throw new SOAPException("Unable to create SOAP connection factory: " + ex.getMessage());
        }
    }
    
    public abstract SOAPConnection createConnection() throws SOAPException;
}
