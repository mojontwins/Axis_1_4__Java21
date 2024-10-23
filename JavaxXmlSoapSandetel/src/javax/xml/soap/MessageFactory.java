package javax.xml.soap;

import java.io.IOException;
import java.io.InputStream;

public abstract class MessageFactory
{
    @SuppressWarnings("unused")
	private static final String DEFAULT_MESSAGE_FACTORY = "com.sun.xml.internal.messaging.saaj.soap.ver1_1.SOAPMessageFactory1_1Impl";
    
    public static MessageFactory newInstance() throws SOAPException {
        try {
            final MessageFactory factory = FactoryFinder.find(MessageFactory.class, "com.sun.xml.internal.messaging.saaj.soap.ver1_1.SOAPMessageFactory1_1Impl", false);
            if (factory != null) {
                return factory;
            }
            return newInstance("SOAP 1.1 Protocol");
        }
        catch (Exception ex) {
            throw new SOAPException("Unable to create message factory for SOAP: " + ex.getMessage());
        }
    }
    
    public static MessageFactory newInstance(final String protocol) throws SOAPException {
        return SAAJMetaFactory.getInstance().newMessageFactory(protocol);
    }
    
    public abstract SOAPMessage createMessage() throws SOAPException;
    
    public abstract SOAPMessage createMessage(final MimeHeaders p0, final InputStream p1) throws IOException, SOAPException;
}
