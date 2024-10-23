package javax.xml.rpc.handler;

import javax.xml.namespace.*;

public abstract class GenericHandler implements Handler
{
    protected GenericHandler() {
    }
    
    @Override
    public boolean handleRequest(final MessageContext context) {
        return true;
    }
    
    @Override
    public boolean handleResponse(final MessageContext context) {
        return true;
    }
    
    @Override
    public boolean handleFault(final MessageContext context) {
        return true;
    }
    
    @Override
    public void init(final HandlerInfo config) {
    }
    
    @Override
    public void destroy() {
    }
    
    @Override
    public abstract QName[] getHeaders();
}
