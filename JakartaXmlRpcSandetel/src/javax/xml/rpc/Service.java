package javax.xml.rpc;

import javax.xml.namespace.*;
import java.rmi.*;
import java.util.*;
import java.net.*;
import javax.xml.rpc.encoding.*;
import javax.xml.rpc.handler.*;

public interface Service
{
    Remote getPort(final QName p0, final Class<?> p1) throws ServiceException;
    
    Remote getPort(final Class<?> p0) throws ServiceException;
    
    Call[] getCalls(final QName p0) throws ServiceException;
    
    Call createCall(final QName p0) throws ServiceException;
    
    Call createCall(final QName p0, final QName p1) throws ServiceException;
    
    Call createCall(final QName p0, final String p1) throws ServiceException;
    
    Call createCall() throws ServiceException;
    
    QName getServiceName();
    
    Iterator<?> getPorts() throws ServiceException;
    
    URL getWSDLDocumentLocation();
    
    TypeMappingRegistry getTypeMappingRegistry();
    
    HandlerRegistry getHandlerRegistry();
}
