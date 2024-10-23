package javax.xml.rpc;

import java.util.*;

public interface Stub
{
    public static final String USERNAME_PROPERTY = "javax.xml.rpc.security.auth.username";
    public static final String PASSWORD_PROPERTY = "javax.xml.rpc.security.auth.password";
    public static final String ENDPOINT_ADDRESS_PROPERTY = "javax.xml.rpc.service.endpoint.address";
    public static final String SESSION_MAINTAIN_PROPERTY = "javax.xml.rpc.session.maintain";
    
    void _setProperty(final String p0, final Object p1);
    
    Object _getProperty(final String p0);
    
    Iterator<?> _getPropertyNames();
}
