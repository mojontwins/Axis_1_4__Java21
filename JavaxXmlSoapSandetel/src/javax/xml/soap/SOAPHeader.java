package javax.xml.soap;

import java.util.Iterator;

import javax.xml.namespace.QName;

public interface SOAPHeader extends SOAPElement
{
    SOAPHeaderElement addHeaderElement(final Name p0) throws SOAPException;
    
    SOAPHeaderElement addHeaderElement(final QName p0) throws SOAPException;
    
    Iterator<SOAPHeaderElement> examineMustUnderstandHeaderElements(final String p0);
    
    Iterator<SOAPHeaderElement> examineHeaderElements(final String p0);
    
    Iterator<SOAPHeaderElement> extractHeaderElements(final String p0);
    
    SOAPHeaderElement addNotUnderstoodHeaderElement(final QName p0) throws SOAPException;
    
    SOAPHeaderElement addUpgradeHeaderElement(final Iterator<String> p0) throws SOAPException;
    
    SOAPHeaderElement addUpgradeHeaderElement(final String[] p0) throws SOAPException;
    
    SOAPHeaderElement addUpgradeHeaderElement(final String p0) throws SOAPException;
    
    Iterator<SOAPHeaderElement> examineAllHeaderElements();
    
    Iterator<SOAPHeaderElement> extractAllHeaderElements();
}
