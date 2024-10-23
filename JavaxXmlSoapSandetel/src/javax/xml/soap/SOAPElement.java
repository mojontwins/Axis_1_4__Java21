package javax.xml.soap;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.w3c.dom.Element;

public interface SOAPElement extends Node, Element
{
    SOAPElement addChildElement(final Name p0) throws SOAPException;
    
    SOAPElement addChildElement(final QName p0) throws SOAPException;
    
    SOAPElement addChildElement(final String p0) throws SOAPException;
    
    SOAPElement addChildElement(final String p0, final String p1) throws SOAPException;
    
    SOAPElement addChildElement(final String p0, final String p1, final String p2) throws SOAPException;
    
    SOAPElement addChildElement(final SOAPElement p0) throws SOAPException;
    
    void removeContents();
    
    SOAPElement addTextNode(final String p0) throws SOAPException;
    
    SOAPElement addAttribute(final Name p0, final String p1) throws SOAPException;
    
    SOAPElement addAttribute(final QName p0, final String p1) throws SOAPException;
    
    SOAPElement addNamespaceDeclaration(final String p0, final String p1) throws SOAPException;
    
    String getAttributeValue(final Name p0);
    
    String getAttributeValue(final QName p0);
    
    Iterator<Name> getAllAttributes();
    
    Iterator<QName> getAllAttributesAsQNames();
    
    String getNamespaceURI(final String p0);
    
    Iterator<String> getNamespacePrefixes();
    
    Iterator<String> getVisibleNamespacePrefixes();
    
    QName createQName(final String p0, final String p1) throws SOAPException;
    
    Name getElementName();
    
    QName getElementQName();
    
    SOAPElement setElementQName(final QName p0) throws SOAPException;
    
    boolean removeAttribute(final Name p0);
    
    boolean removeAttribute(final QName p0);
    
    boolean removeNamespaceDeclaration(final String p0);
    
    Iterator<Node> getChildElements();
    
    Iterator<Node> getChildElements(final Name p0);
    
    Iterator<Node> getChildElements(final QName p0);
    
    void setEncodingStyle(final String p0) throws SOAPException;
    
    String getEncodingStyle();
}
