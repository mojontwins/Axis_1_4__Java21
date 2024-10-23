package javax.xml.rpc.handler;

import java.util.*;

public interface MessageContext
{
    void setProperty(final String p0, final Object p1);
    
    Object getProperty(final String p0);
    
    void removeProperty(final String p0);
    
    boolean containsProperty(final String p0);
    
    Iterator<?> getPropertyNames();
}
