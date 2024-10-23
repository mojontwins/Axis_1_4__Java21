package javax.xml.rpc;

import javax.xml.namespace.*;
import java.rmi.*;
import java.util.*;

public interface Call
{
    public static final String USERNAME_PROPERTY = "javax.xml.rpc.security.auth.username";
    public static final String PASSWORD_PROPERTY = "javax.xml.rpc.security.auth.password";
    public static final String OPERATION_STYLE_PROPERTY = "javax.xml.rpc.soap.operation.style";
    public static final String SOAPACTION_USE_PROPERTY = "javax.xml.rpc.soap.http.soapaction.use";
    public static final String SOAPACTION_URI_PROPERTY = "javax.xml.rpc.soap.http.soapaction.uri";
    public static final String ENCODINGSTYLE_URI_PROPERTY = "javax.xml.rpc.encodingstyle.namespace.uri";
    public static final String SESSION_MAINTAIN_PROPERTY = "javax.xml.rpc.session.maintain";
    
    boolean isParameterAndReturnSpecRequired(final QName p0);
    
    void addParameter(final String p0, final QName p1, final ParameterMode p2);
    
    void addParameter(final String p0, final QName p1, final Class<?> p2, final ParameterMode p3);
    
    QName getParameterTypeByName(final String p0);
    
    void setReturnType(final QName p0);
    
    void setReturnType(final QName p0, final Class<?> p1);
    
    QName getReturnType();
    
    void removeAllParameters();
    
    QName getOperationName();
    
    void setOperationName(final QName p0);
    
    QName getPortTypeName();
    
    void setPortTypeName(final QName p0);
    
    void setTargetEndpointAddress(final String p0);
    
    String getTargetEndpointAddress();
    
    void setProperty(final String p0, final Object p1);
    
    Object getProperty(final String p0);
    
    void removeProperty(final String p0);
    
    Iterator<?> getPropertyNames();
    
    Object invoke(final Object[] p0) throws RemoteException;
    
    Object invoke(final QName p0, final Object[] p1) throws RemoteException;
    
    void invokeOneWay(final Object[] p0);
    
    Map<?, ?> getOutputParams();
    
    List<?> getOutputValues();
}
