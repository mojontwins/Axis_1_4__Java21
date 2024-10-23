package javax.xml.rpc.handler.soap;

import javax.xml.rpc.handler.*;
import javax.xml.soap.*;

public interface SOAPMessageContext extends MessageContext
{
    SOAPMessage getMessage();
    
    void setMessage(final SOAPMessage p0);
    
    String[] getRoles();
}
