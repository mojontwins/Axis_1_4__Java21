package javax.xml.soap;

public interface SOAPHeaderElement extends SOAPElement
{
    void setActor(final String p0);
    
    void setRole(final String p0) throws SOAPException;
    
    String getActor();
    
    String getRole();
    
    void setMustUnderstand(final boolean p0);
    
    boolean getMustUnderstand();
    
    void setRelay(final boolean p0) throws SOAPException;
    
    boolean getRelay();
}
