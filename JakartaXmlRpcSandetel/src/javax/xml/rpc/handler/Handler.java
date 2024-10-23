package javax.xml.rpc.handler;

import javax.xml.namespace.*;

public interface Handler
{
    boolean handleRequest(final MessageContext p0);
    
    boolean handleResponse(final MessageContext p0);
    
    boolean handleFault(final MessageContext p0);
    
    void init(final HandlerInfo p0);
    
    void destroy();
    
    QName[] getHeaders();
}
