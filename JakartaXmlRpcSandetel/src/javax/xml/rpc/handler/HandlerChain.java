package javax.xml.rpc.handler;

import java.util.*;

public interface HandlerChain extends List<Object>
{
    boolean handleRequest(final MessageContext p0);
    
    boolean handleResponse(final MessageContext p0);
    
    boolean handleFault(final MessageContext p0);
    
    void init(final Map<?, ?> p0);
    
    void destroy();
    
    void setRoles(final String[] p0);
    
    String[] getRoles();
}
