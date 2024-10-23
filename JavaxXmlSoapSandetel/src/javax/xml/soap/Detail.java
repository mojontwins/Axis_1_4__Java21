package javax.xml.soap;

import java.util.Iterator;

import javax.xml.namespace.QName;

public interface Detail extends SOAPFaultElement
{
    DetailEntry addDetailEntry(final Name p0) throws SOAPException;
    
    DetailEntry addDetailEntry(final QName p0) throws SOAPException;
    
    Iterator<DetailEntry> getDetailEntries();
}
