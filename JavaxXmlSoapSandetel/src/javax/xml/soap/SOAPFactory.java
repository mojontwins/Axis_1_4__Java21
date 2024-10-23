package javax.xml.soap;

import javax.xml.namespace.QName;

import org.w3c.dom.Element;

public abstract class SOAPFactory
{
    @SuppressWarnings("unused")
	private static final String DEFAULT_SOAP_FACTORY = "com.sun.xml.internal.messaging.saaj.soap.ver1_1.SOAPFactory1_1Impl";
    
    public SOAPElement createElement(final Element domElement) throws SOAPException {
        throw new UnsupportedOperationException("createElement(org.w3c.dom.Element) must be overridden by all subclasses of SOAPFactory.");
    }
    
    public abstract SOAPElement createElement(final Name p0) throws SOAPException;
    
    public SOAPElement createElement(final QName qname) throws SOAPException {
        throw new UnsupportedOperationException("createElement(QName) must be overridden by all subclasses of SOAPFactory.");
    }
    
    public abstract SOAPElement createElement(final String p0) throws SOAPException;
    
    public abstract SOAPElement createElement(final String p0, final String p1, final String p2) throws SOAPException;
    
    public abstract Detail createDetail() throws SOAPException;
    
    public abstract SOAPFault createFault(final String p0, final QName p1) throws SOAPException;
    
    public abstract SOAPFault createFault() throws SOAPException;
    
    public abstract Name createName(final String p0, final String p1, final String p2) throws SOAPException;
    
    public abstract Name createName(final String p0) throws SOAPException;
    
    public static SOAPFactory newInstance() throws SOAPException {
        try {
            final SOAPFactory factory = FactoryFinder.find(SOAPFactory.class, "com.sun.xml.internal.messaging.saaj.soap.ver1_1.SOAPFactory1_1Impl", false);
            if (factory != null) {
                return factory;
            }
            return newInstance("SOAP 1.1 Protocol");
        }
        catch (Exception ex) {
            throw new SOAPException("Unable to create SOAP Factory: " + ex.getMessage());
        }
    }
    
    public static SOAPFactory newInstance(final String protocol) throws SOAPException {
        return SAAJMetaFactory.getInstance().newSOAPFactory(protocol);
    }
}
