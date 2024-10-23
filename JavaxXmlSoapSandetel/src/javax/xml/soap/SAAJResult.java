package javax.xml.soap;

import javax.xml.transform.dom.DOMResult;

public class SAAJResult extends DOMResult
{
    public SAAJResult() throws SOAPException {
        this(MessageFactory.newInstance().createMessage());
    }
    
    public SAAJResult(final String protocol) throws SOAPException {
        this(MessageFactory.newInstance(protocol).createMessage());
    }
    
    public SAAJResult(final SOAPMessage message) {
        super(message.getSOAPPart());
    }
    
    public SAAJResult(final SOAPElement rootNode) {
        super(rootNode);
    }
    
    public javax.xml.soap.Node getResult() {
        return (javax.xml.soap.Node)super.getNode().getFirstChild();
    }
}
