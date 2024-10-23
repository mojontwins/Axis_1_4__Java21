package javax.xml.soap;

import java.util.Locale;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;

public interface SOAPBody extends SOAPElement
{
    SOAPFault addFault() throws SOAPException;
    
    SOAPFault addFault(final Name p0, final String p1, final Locale p2) throws SOAPException;
    
    SOAPFault addFault(final QName p0, final String p1, final Locale p2) throws SOAPException;
    
    SOAPFault addFault(final Name p0, final String p1) throws SOAPException;
    
    SOAPFault addFault(final QName p0, final String p1) throws SOAPException;
    
    boolean hasFault();
    
    SOAPFault getFault();
    
    SOAPBodyElement addBodyElement(final Name p0) throws SOAPException;
    
    SOAPBodyElement addBodyElement(final QName p0) throws SOAPException;
    
    SOAPBodyElement addDocument(final Document p0) throws SOAPException;
    
    Document extractContentAsDocument() throws SOAPException;
}
