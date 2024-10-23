package javax.xml.rpc.server;

import javax.xml.rpc.*;

public interface ServiceLifecycle
{
    void init(final Object p0) throws ServiceException;
    
    void destroy();
}
