package javax.xml.rpc;

import java.net.*;
import javax.xml.namespace.*;
import java.util.*;

public abstract class ServiceFactory
{
    public static final String SERVICEFACTORY_PROPERTY = "javax.xml.rpc.ServiceFactory";
    @SuppressWarnings("unused")
	private static final String DEFAULT_SERVICEFACTORY = "com.sun.xml.rpc.client.ServiceFactoryImpl";
    
    protected ServiceFactory() {
    }
    
    public static ServiceFactory newInstance() throws ServiceException {
        try {
            return (ServiceFactory)FactoryFinder.find("javax.xml.rpc.ServiceFactory", "com.sun.xml.rpc.client.ServiceFactoryImpl");
        }
        catch (ServiceException ex) {
            throw ex;
        }
        catch (Exception ex2) {
            throw new ServiceException("Unable to create Service Factory: " + ex2.getMessage());
        }
    }
    
    public abstract Service createService(final URL p0, final QName p1) throws ServiceException;
    
    public abstract Service createService(final QName p0) throws ServiceException;
    
    public abstract Service loadService(final Class<?> p0) throws ServiceException;
    
    public abstract Service loadService(final URL p0, final Class<?> p1, final Properties p2) throws ServiceException;
    
    public abstract Service loadService(final URL p0, final QName p1, final Properties p2) throws ServiceException;
}
