package javax.xml.soap;

public abstract class SAAJMetaFactory
{
    @SuppressWarnings("unused")
	private static final String META_FACTORY_DEPRECATED_CLASS_PROPERTY = "jakarta.xml.soap.MetaFactory";
    @SuppressWarnings("unused")
    private static final String DEFAULT_META_FACTORY_CLASS = "com.sun.xml.internal.messaging.saaj.soap.SAAJMetaFactoryImpl";
    
    static SAAJMetaFactory getInstance() throws SOAPException {
        try {
            return FactoryFinder.find(SAAJMetaFactory.class, "com.sun.xml.internal.messaging.saaj.soap.SAAJMetaFactoryImpl", true, "jakarta.xml.soap.MetaFactory");
        }
        catch (Exception e) {
            throw new SOAPException("Unable to create SAAJ meta-factory: " + e.getMessage());
        }
    }
    
    protected SAAJMetaFactory() {
    }
    
    protected abstract MessageFactory newMessageFactory(final String p0) throws SOAPException;
    
    protected abstract SOAPFactory newSOAPFactory(final String p0) throws SOAPException;
}
