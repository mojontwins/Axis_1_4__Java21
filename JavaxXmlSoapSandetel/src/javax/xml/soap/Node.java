package javax.xml.soap;

public interface Node extends org.w3c.dom.Node
{
    String getValue();
    
    void setValue(final String p0);
    
    void setParentElement(final SOAPElement p0) throws SOAPException;
    
    SOAPElement getParentElement();
    
    void detachNode();
    
    void recycleNode();
}
